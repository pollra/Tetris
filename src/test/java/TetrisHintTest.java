import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import tetris.app.main.basis.entity.Block;
import tetris.app.main.basis.entity.TetrisHint;
import tetris.app.main.basis.exception.HintException;

import java.util.List;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description TetrisHintTest
 **********************************************************************************************************************/
public class TetrisHintTest {

    @Test
    public void 테스트_블록이_랜덤으로_잘_생성됨(){
        final TetrisHint tetrisHints = new TetrisHint();
        Block block;
        int errorCount = 0;
        int minError=0, maxError=0;
        int currentBlock = 0;

        for (int i = 0; i < 100000; i++) {
            block = tetrisHints.next();
            currentBlock = block.getColor().getNumber();
            if(currentBlock < 0){
                minError++;
            }else if( currentBlock > 6){
                maxError++;
            }
            System.out.println(block.getColor().getNumber());
        }
        System.out.println("minError: "+minError+", maxError: "+maxError);
        Assertions.assertEquals(maxError+minError, 0);
    }
}
