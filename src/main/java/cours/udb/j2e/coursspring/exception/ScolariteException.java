package cours.udb.j2e.coursspring.exception;

public class ScolariteException extends RuntimeException {
    public ScolariteException(String message) {
        super(message);
    }

    public ScolariteException(String message, Throwable cause) {
        super(message, cause);
    }
}
