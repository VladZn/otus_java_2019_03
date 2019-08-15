package exception;

public class NotEnoughBanknotesException extends BusinessException {
    public NotEnoughBanknotesException(String message) {
        super(message);
    }

    public NotEnoughBanknotesException(String message, Throwable cause) {
        super(message, cause);
    }
}
