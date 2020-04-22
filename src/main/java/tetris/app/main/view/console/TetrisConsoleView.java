package tetris.app.main.view.console;

import lombok.Data;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description
 * @역할         화면에 일정 주기로 표현할 데이터를 리턴하는 역할
 * @책임         바로 찍으면 해당화면이 나와야 함
 **********************************************************************************************************************/
public class TetrisConsoleView {

    private final int MAX_TETRIS_WIDTH = 12;
    private final int MAX_TETRIS_HEIGHT = 24;

    private String[][] fullMap;
    private String[][] tetrisMapContainer;
    private String[][] tetrisHintContainer;

}
