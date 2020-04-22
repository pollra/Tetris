import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetris.app.main.basis.entity.Block;
import tetris.app.main.basis.entity.TetrisBoard;
import tetris.app.main.basis.entity.TetrisHint;

/**
 * @since       2020.04.12
 * @author      pollra
 * @description TetrisBoardTest
 **********************************************************************************************************************/
public class TetrisBoardTest {

    @BeforeEach
    void setUp(){

    }

    @Test
    void 모형과_좌표를_합쳐서_보드에_정상적으로_표시(){
        TetrisBoard tetrisBoard = new TetrisBoard();
        int[][] exceptedGameBoard = {
                {-1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };



    }
}
