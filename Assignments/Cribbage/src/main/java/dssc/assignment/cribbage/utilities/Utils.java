package dssc.assignment.cribbage.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Utils {
    public static List<String> splitStringEvery(String string, int interval) {
        List<String> splits = new ArrayList<>();
        for (int startIndex = 0; startIndex < string.length(); startIndex += interval) {
            String split = string.substring(startIndex, startIndex + interval);
            splits.add(split);
        }
        return splits;
    }

    public static <T> List<T> joinLists(List<T> listOne, List<T> listTwo) {
        return Stream.concat(listOne.stream(), listTwo.stream())
                .collect(Collectors.toList());
    }

    public static <R> Set<List<R>> getAllSubListsOfNElements(List<R> list, int n) {
        Set<List<R>> allSubLists = new HashSet<>();

        if (n <= 0 || n > list.size()) {
            return createEmptySetOfLists();
        }

        List<R> listCopy = new ArrayList<>(List.copyOf(list));
        for (int index = 0; index < list.size() - n + 1; index++) {
            R element = listCopy.remove(0);

            Set<List<R>> subLists = getAllSubListsOfNElements(listCopy, n - 1);

            addElementToAllLists(subLists, element);

            allSubLists.addAll(subLists);
        }

        return allSubLists;
    }

    private static <R> Set<List<R>> createEmptySetOfLists() {
        Set<List<R>> allSubLists = new HashSet<>();
        allSubLists.add(new ArrayList<>());
        return allSubLists;
    }

    public static <R> void addElementToAllLists(Set<List<R>> lists, R element) {
        for (List<R> list : lists) {
            list.add(element);
        }
    }
}
