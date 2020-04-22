package tetris.app.main.command.exception;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description CommandNotFoundException
 **********************************************************************************************************************/
public class CommandNotFoundException extends CommandException {
    public CommandNotFoundException(String message) {
        super(message);
    }
}
