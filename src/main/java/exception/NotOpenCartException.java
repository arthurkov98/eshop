package exception;

public class NotOpenCartException extends Exception {
    public NotOpenCartException(String errorMessage) {
        super(errorMessage);
    }
}