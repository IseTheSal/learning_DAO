package by.learning.hospital.model.exception;

public class DeletingException extends Exception {

    public DeletingException() {
    }

    public DeletingException(String message) {
        super(message);
    }

    public DeletingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeletingException(Throwable cause) {
        super(cause);
    }
}
