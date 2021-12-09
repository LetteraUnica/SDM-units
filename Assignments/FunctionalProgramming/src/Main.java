import java.util.function.Function;
import java.util.function.IntFunction;

@FunctionalInterface
interface StringFunction<R> {
    R apply(String value);
}

public class Main {
    public static void main(String[] args) {
        // Before
        IntFunction g = new IntFunction() {
            @Override
            public Object apply(int i) {
                return i * i;
            }
        };
        // After
        IntFunction g_lambda = i -> i*i;

        // Functional interface
        // Before
        StringFunction m = new StringFunction() {
            @Override
            public Object apply(String value) {
                return value.contains("a");
            }
        };

        // After
        StringFunction<Boolean> m_lambda = x -> x.contains("a");

        // Example of a generic function
        Function<Integer, Double> p = x -> x.doubleValue()/10;

        System.out.println(p.apply(102));
    }
}


