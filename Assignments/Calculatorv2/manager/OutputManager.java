package manager;

public class OutputManager {
    public void display(String s) {
        System.out.println(s);
    }

    public void display(char c) {
        display(String.valueOf(c));
    }

    public void display(double d) {
        display(String.valueOf(d));
    }
}