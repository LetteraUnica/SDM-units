import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzz {

    public String numberToFizzBuzz(int number) {
        String conversionResult = "";

        if (isMultipleOf(number, 3)) {
            conversionResult += "Fizz";
        }
        if (isMultipleOf(number, 5)) {
            conversionResult += "Buzz";
        }

        if (conversionResult.equals("")) {
            return String.valueOf(number);
        }

        return conversionResult;
    }

    private boolean isMultipleOf(int number, int divisor) {
        return number % divisor == 0;
    }

    public void printFizzBuzzesUntil(int number) {
        System.out.println(fizzBuzzesStreamUntil(number).
                collect(Collectors.joining(", ")));
    }

    private Stream<String> fizzBuzzesStreamUntil(int number) {
        return IntStream.range(1, number).
                mapToObj(this::numberToFizzBuzz);
    }
}
