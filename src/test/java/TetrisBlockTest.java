import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import tetris.app.main.basis.entity.Block;
import tetris.app.main.basis.entity.TetrisBlock;
import tetris.app.main.basis.exception.BlockException;

/**
 * @since       2020.04.13
 * @author      pollra
 * @description TetrisBlockTest
 **********************************************************************************************************************/
public class TetrisBlockTest {

    @Test
    public void L_블록_스페이스가_정상적으로_생성됨(){
        TetrisBlock tetrisBlock = new TetrisBlock(Block.L);
        final int L = Block.L.getColor().getNumber();
        int[][] exceptedBoard = {
                {-1, 0, 0, 0, 0, L, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, L, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, L, L, 0, 0, 0, 0, -1},
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

        int[][] actResult = tetrisBlock.boardSpacePrinter();

        for (int i = 0; i < exceptedBoard.length; i++) {
            Assertions.assertArrayEquals(exceptedBoard[i], actResult[i]);
        }
    }

    @Test
    public void 블록이_왼쪽_벽을_뚫으려고_함(){
        TetrisBlock tetrisBlock = new TetrisBlock(Block.T);
        Assertions.assertThrows(
                BlockException.class,
                ()->{
                    tetrisBlock.moveLeft();
                    tetrisBlock.moveLeft();
                    tetrisBlock.moveLeft();
                    tetrisBlock.moveLeft();
                    tetrisBlock.moveLeft();
                }
        );
    }

    @Test
    public void 블록의_모형을_성공적으로_변경함(){
        System.out.println("1");
    }
}
