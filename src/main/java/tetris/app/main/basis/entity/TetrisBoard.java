package tetris.app.main.basis.entity;

import tetris.app.main.basis.exception.BoardException;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description TetrisGameBoard
 **********************************************************************************************************************/
public class TetrisBoard {
    private static final int[][] DEFAULT_GAME_BOARD = new int[][]{
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
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
    };

    private int[][] gameBoard;

    public TetrisBoard() {
        this.gameBoard = DEFAULT_GAME_BOARD;
    }

    public int[][] currentBoardPrint(){
        return gameBoard;
    }

    public int[][] getCombinationBoard(int[][] blockSpace){
        int[][] result = new int[24][12];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                result[i][j] = gameBoard[i][j] + blockSpace[i][j];
            }
        }
        return result;
    }

    public int[][] combinationCheck(int[][] boardSpace, int[][] blockLocation, int color){
        int[][] result = getCombinationBoard(boardSpace);
        for (int i = 0; i < blockLocation.length; i++) {
            if( result[blockLocation[i][0]][blockLocation[i][1]] != color){
                throw new BoardException("겹치는 항목이 존재합니다. 해당 좌표로 이동할 수 없습니다");
            }
        }
        return result;
    }


    public void save(int[][] blockSpace){
        this.gameBoard = getCombinationBoard(blockSpace);
    }

}
