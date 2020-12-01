package by.learning.hospital.exception;

 public class AddingException extends Exception {

    public AddingException() {
    }

    public AddingException(String message) {
        super(message);
    }

    public AddingException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddingException(Throwable cause) {
        super(cause);
    }

}
