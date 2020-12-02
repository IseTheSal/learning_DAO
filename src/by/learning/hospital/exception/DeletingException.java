package by.learning.hospital.exception;

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
