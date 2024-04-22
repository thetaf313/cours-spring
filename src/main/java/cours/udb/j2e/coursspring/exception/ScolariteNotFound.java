package cours.udb.j2e.coursspring.exception;

public class ScolariteNotFound extends ScolariteException {

    public ScolariteNotFound(String message) {
        super(message);
    }

    public ScolariteNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
