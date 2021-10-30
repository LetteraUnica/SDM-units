package exceptions;

public class OperationException extends Exception {
    String message;
    public OperationException(String message) {
        this.message = message;
    }
}
