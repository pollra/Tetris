package tetris.app.main.basis.exception;

/**
 * @since       2020.04.20
 * @author      pollra
 * @description CanNotMoveException
 **********************************************************************************************************************/
public class CanNotMoveException extends BlockException{
    public CanNotMoveException(String message) {
        super(message);
    }
}
