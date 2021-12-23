package dssc.assignment.cribbage.utilities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static dssc.assignment.cribbage.utilities.Math.binomial;
import static dssc.assignment.cribbage.utilities.Math.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MathUtilsTest {

    @ParameterizedTest
    @CsvSource({"1,1", "0,1", "3,6", "4,24", "20,2432902008176640000"})
    void factorialTest(int input, long expectedValue) {
        long actualValue = factorial(input);
        assertEquals(expectedValue, actualValue);
    }

    @ParameterizedTest
    @CsvSource({"1,1,1", "20,10,184756", "20,15,15504", "13,2,78"})
    void binomialTest(int n, int k, int expectedValue) {
        long actualValue = binomial(n, k);
        assertEquals(expectedValue, actualValue);
    }
}
