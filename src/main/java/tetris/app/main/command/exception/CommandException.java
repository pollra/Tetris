package tetris.app.main.command.exception;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description CommandException
 **********************************************************************************************************************/
public class CommandException extends RuntimeException {
    public CommandException(String message) {
        super(message);
    }
}
