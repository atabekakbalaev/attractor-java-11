package step01;

public class NullOrEmptyTextException extends Exception{
    public NullOrEmptyTextException() {
    }

    public NullOrEmptyTextException(String message) {
        super(message);
    }
}
