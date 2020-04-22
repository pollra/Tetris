import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tetris.app.main.basis.entity.Block;
import tetris.app.main.basis.entity.TetrisShape;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @since       2020.04.08
 * @author      pollra
 * @description TetrisBlockTest
 **********************************************************************************************************************/
public class TetrisShapeTest {

    @Test
    void 무조건_성공하는_테스트(){
        assertEquals(true, true);
    }

    @Test
    void 모든_블록이_정상적으로_생성되어_올바른_좌표를_리턴함(){
        // arrange
        TetrisShape blockArray[] = {
                new TetrisShape(Block.L),
                new TetrisShape(Block.J),
                new TetrisShape(Block.Z),
                new TetrisShape(Block.S),
                new TetrisShape(Block.T),
                new TetrisShape(Block.O),
                new TetrisShape(Block.I),
        };
        int[][][] expectedValue = {
                {{-1, 0}, {0, 0}, {1, 0}, {1, 1}}, // L
                {{-1, 0}, {0, 0}, {1, 0}, {1, -1}}, // J
                {{-1, 0}, {0, 0}, {-1, -1}, {0, 1}}, // Z
                {{-1, 0}, {0, 0}, {-1, 1}, {0, -1}}, // S
                {{-1, 0}, {0, 0}, {0, 1}, {0, -1}}, // T
                {{-1, 0}, {0, 0}, {-1, 0}, {-1, -1}}, // O
                {{-1, 0}, {0, 0}, {1, 0}, {2, 0}}  // I
        };
        int[] defaultXYPath = {1, 5};
        // act
        int[][][] resultBlock = new int[7][4][2];
        for (int i = 0; i < blockArray.length; i++) {
            resultBlock[i] = blockArray[i].currentShapePrinter();
            for (int j = 0; j < expectedValue[i].length; j++) {
                resultBlock[i][j][0] += defaultXYPath[0];
                resultBlock[i][j][1] += defaultXYPath[1];
                expectedValue[i][j][0] += defaultXYPath[0];
                expectedValue[i][j][1] += defaultXYPath[1];
            }
        }
        // assert
        for (int i = 0; i < expectedValue.length; i++)
            for (int j = 0; j < expectedValue[i].length; j++)
                Assertions.assertArrayEquals(expectedValue[i], resultBlock[i]);
    }

    @Test
    void L_블록_회전이_정상적으로_수행됨(){
        TetrisShape tetrisShape = new TetrisShape(Block.L);
        int[][] expectedValue = {{0, 1}, {0, 0}, {0, -1}, {1, -1}};

        tetrisShape.rotateRight();
        int[][] resultBlock = tetrisShape.currentShapePrinter();

        for (int i = 0; i < resultBlock.length; i++) {
            System.out.println(Arrays.toString(resultBlock[i]));
        }

        for (int i = 0; i < expectedValue.length; i++)
            Assertions.assertArrayEquals(expectedValue[i], resultBlock[i]);
    }

    public int[][] array2DClone(int[][] target){
        int[][] result = new int[24][12];
        for (int i = 0; i < target.length; i++) {
            result[i] = Arrays.copyOf(target[i], target[i].length);
        }
        return result;
    }
}