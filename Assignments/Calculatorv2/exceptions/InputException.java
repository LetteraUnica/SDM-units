package exceptions;

public class InputException extends Exception {
    String message;
    public InputException(String message) {
        this.message = message;
    }
}
