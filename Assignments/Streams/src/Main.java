import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,4,4,5,6,7,8);

        List<Integer> filtered = integers.stream().
                filter(i -> i < 7).
                filter(i -> i > 3).
                map(i -> i + i).
                distinct().
                collect(Collectors.toList());

        filtered.forEach(System.out::println);
    }
}
