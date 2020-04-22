package tetris.app.main.basis.exception;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description BusinessException
 **********************************************************************************************************************/
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
