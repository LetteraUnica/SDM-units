package collection.exceptions;

public class FullCollectionException extends Throwable {
    String message;
    public FullCollectionException(String message) {
        this.message = message;
    }
}
