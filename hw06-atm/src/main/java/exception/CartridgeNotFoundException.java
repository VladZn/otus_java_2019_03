package exception;

/**
 * @author V. Zinchenko
 */
public class CartridgeNotFoundException extends BusinessException {
    public CartridgeNotFoundException(String message) {
        super(message);
    }

    public CartridgeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
