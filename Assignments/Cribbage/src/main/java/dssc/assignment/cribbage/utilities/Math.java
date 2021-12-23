package dssc.assignment.cribbage.utilities;

public class Math {
    public static long factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int binomial(int n, int k) {
        return (int) (factorial(n) / (factorial(k) * factorial(n - k)));
    }

}
