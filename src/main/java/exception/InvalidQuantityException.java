package exception;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String errorMessage) {
        super(errorMessage);
    }
}
