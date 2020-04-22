package tetris.app.main.basis.service;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description TetrisService
 **********************************************************************************************************************/
public interface TetrisService {

    int[][] leftMove();
    int[][] rightMove();
    int[][] downMove();
    int[][] transform();

    int[][] fastDown();
    int[][] stop();

}
