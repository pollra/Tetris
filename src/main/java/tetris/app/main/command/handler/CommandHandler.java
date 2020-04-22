package tetris.app.main.command.handler;

import javafx.scene.input.KeyEvent;
import lombok.AllArgsConstructor;
import tetris.app.main.basis.service.TetrisService;
import tetris.app.main.command.entity.Command;
import tetris.app.main.command.exception.CommandNotFoundException;

import static tetris.app.main.command.entity.Command.*;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description CommandHandler
 **********************************************************************************************************************/
public class CommandHandler {

    private TetrisService tetrisService;

    public CommandHandler(TetrisService tetrisService) {
        this.tetrisService = tetrisService;
    }

    public int[][] command(KeyEvent requestCommand){
        System.out.println("입력된 커맨드: "+ requestCommand.getCode());
        switch (requestCommand.getCode()) {
            case LEFT:
                return tetrisService.leftMove();
            case RIGHT:
                return tetrisService.rightMove();
            case UP:
                return tetrisService.transform();
            case DOWN:
                return tetrisService.downMove();
            case PAUSE:
                System.out.println("아직 구현되지 않은 기능 입니다");
//                return tetrisService.stop();
            case SPACE:
                System.out.println("아직 구현되지 않은 기능 입니다");
//                return tetrisService.fastDown();
            default:
                throw new CommandNotFoundException("지원되지 않는 커맨드 입력입니다.");
        }
    }
}
