import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    public String numberToFizzBuzz(int number) {
        String conversionResult = "";

        if (number % 3 == 0) {
            conversionResult += "Fizz";
        }
        if (number % 5 == 0) {
            conversionResult += "Buzz";
        }

        if (conversionResult.equals("")) {
            return String.valueOf(number);
        }

        return conversionResult;
    }

    public void printUntil(int number) {
        System.out.println(IntStream.range(1, number).
                mapToObj(this::numberToFizzBuzz).
                collect(Collectors.joining(", ")));
    }
}
