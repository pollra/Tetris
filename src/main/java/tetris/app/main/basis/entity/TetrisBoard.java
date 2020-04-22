package tetris.app.main.basis.entity;

import tetris.app.main.basis.exception.BoardException;
import tetris.app.main.tools.MyArrays;

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
        int[][] result = MyArrays.clone2D(gameBoard);
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if(blockSpace[i][j] > 0 && result[i][j]+blockSpace[i][j] == blockSpace[i][j]){
                    result[i][j] = blockSpace[i][j];
                }
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
        int[][] saveBoard = setSaveBlock(blockSpace);

        this.gameBoard = setSaveBlock(blockSpace);
    }

    private int[][] setSaveBlock(int[][] blockSpace){
        int[][] saveBlock = MyArrays.clone2D(getCombinationBoard(blockSpace));
        for (int i = 0; i < saveBlock.length; i++) {
            for (int j = 0; j < saveBlock[i].length; j++) {
                if(saveBlock[i][j] > 0 && saveBlock[i][j] <= Block.values().length){
                    saveBlock[i][j] += 10;
                }
            }
        }
        return saveBlock;
    }

    private void deleteLine(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

            }
        }
    }

}
