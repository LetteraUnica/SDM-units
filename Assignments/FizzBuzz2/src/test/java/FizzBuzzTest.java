import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void numberToString() {
        assertEquals("1", fizzBuzz.numberToFizzBuzz(1));
        assertEquals("7", fizzBuzz.numberToFizzBuzz(7));
    }

    @Test
    void numberToFizz() {
        assertEquals("Fizz", fizzBuzz.numberToFizzBuzz(3));
        assertEquals("Fizz", fizzBuzz.numberToFizzBuzz(9));
    }

    @Test
    void numberToBuzz() {
        assertEquals("Buzz", fizzBuzz.numberToFizzBuzz(5));
        assertEquals("Buzz", fizzBuzz.numberToFizzBuzz(40));
    }

    @Test
    void numberToFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.numberToFizzBuzz(15));
        assertEquals("FizzBuzz", fizzBuzz.numberToFizzBuzz(90));
    }

    @Test
    void fizzBuzzesToOutputStream() {
        ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOutputStream));

        fizzBuzz.printFizzBuzzesUntil(16);

        String fizzBuzzes = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz\n";
        assertEquals(fizzBuzzes, myOutputStream.toString());
    }
}
