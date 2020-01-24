package pl.ug.virtualofficebackend.domain.security.internal.exception;

public class WrongTokenException extends Exception {
    public WrongTokenException(String s) {
        super(s);
    }
}
