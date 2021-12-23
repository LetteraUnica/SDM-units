package dssc.assignment.cribbage.utilities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    @ParameterizedTest
    @CsvSource({"3, 3, 1", "4, 2, 6", "0, 0, 1", "10, 11, 1"})
    void getAllSubListsSize(int listSize, int n, int expected) {
        List<Integer> myList = IntStream.range(0, listSize).boxed().collect(Collectors.toList());
        assertEquals(expected, Utils.getAllSubListsOfNElements(myList, n).size());
    }
}
