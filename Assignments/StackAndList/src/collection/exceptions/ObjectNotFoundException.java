package collection.exceptions;

public class ObjectNotFoundException extends Exception {
    final String message;
    public ObjectNotFoundException(String message) {
        this.message = message;
    }
}
