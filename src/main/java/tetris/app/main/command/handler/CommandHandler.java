package tetris.app.main.command.handler;

import javafx.scene.input.KeyEvent;
import tetris.app.main.basis.service.GameBoard;
import tetris.app.main.command.exception.CommandNotFoundException;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description CommandHandler
 **********************************************************************************************************************/
public class CommandHandler {

    private GameBoard gameBoard;

    public CommandHandler(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int[][] command(KeyEvent requestCommand){
        System.out.println("입력된 커맨드: "+ requestCommand.getCode());
        switch (requestCommand.getCode()) {
            case LEFT:
                return gameBoard.leftMove();
            case RIGHT:
                return gameBoard.rightMove();
            case UP:
                return gameBoard.transform();
            case DOWN:
                return gameBoard.downMove();
            case PAUSE:
                System.out.println("아직 구현되지 않은 기능 입니다");
//                return tetrisService.stop();
            case SPACE:
                return gameBoard.fastDown();
            default:
                throw new CommandNotFoundException("지원되지 않는 커맨드 입력입니다.");
        }
    }
}
