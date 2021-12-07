package step02;

public class InvalidOptionException extends Exception {
    public InvalidOptionException() {
    }

    public InvalidOptionException(String message) {
        super(message);
    }
}
