package step01;

public class InvalidYearException extends Exception {
    public InvalidYearException() {
    }

    public InvalidYearException(String message) {
        super(message);
    }
}
