package tetris.app.main.basis.entity;

import tetris.app.main.basis.exception.BoardException;
import tetris.app.main.tools.MyArrays;

import java.util.ArrayList;
import java.util.Arrays;

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
//        int[][] saveBoard = setSaveBlock(blockSpace);

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

    public void eraseLine() {
        for (int line = 0; line < gameBoard.length-1; line++) {
            if(widthLineIsPull(line)){
                oneRowErase(line);
            }
        }
    }

    private void oneRowErase(int line){
        for (int i = 0; i < gameBoard[line].length; i++) {
            if(gameBoard[line][i] > 0){
                gameBoard[line][i] = 0;
            }else{
                gameBoard[line][i] = -1;
            }
        }
    }

    private boolean widthLineIsPull(int line){
        int voidCount = 0;
        for (int i = 0; i < gameBoard[line].length; i++) {
            if(gameBoard[line][i] > Block.values().length || gameBoard[line][i] < 0){
                voidCount++;
            }
        }
        return voidCount == 12;
    }

    private boolean widthHaveBlock(int line){
        int blockCount = 0;
        for (int i = 0; i < gameBoard[line].length; i++) {
            if(gameBoard[line][i] > 0){
                blockCount++;
            }
        }
        return blockCount != 0;
    }

    // 빈 공간이면 블록을 저장하지 않고
    // 블록이 하나라도 있으면 현재의 블록을 저장
    // 아래로 내려오면서 모두 저장한 블록을
    // gameBoard 에 담음
    public void blocksPullDown(){
        System.out.println("blocksPullDown");
        ArrayList<int[]> moveBlockList = new ArrayList();
        for (int line = 0; line < gameBoard.length; line++) {
            if(widthHaveBlock(line)) {
                moveBlockList.add(oneLineSaver(line));
                System.out.println("다음의 블록을 저장합니다: "+Arrays.toString(moveBlockList.get(moveBlockList.size()-1)));
            }
        }
        int topHeight = gameBoard.length-1 - moveBlockList.size();
        System.out.println("topHeight = "+ topHeight);
        int arrayIndex = 0;
        int[] noneLineBoard = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1};
        for (int line = 0; line < topHeight; line++) {
            gameBoard[line] = Arrays.copyOf(noneLineBoard, noneLineBoard.length);
        }
        for (int line = topHeight; line < gameBoard.length-1; line++) {
            gameBoard[line] = moveBlockList.get(arrayIndex++);
        }
        print();

    }

    private int[] oneLineSaver(int line){
        return Arrays.copyOf(gameBoard[line], gameBoard[line].length);
    }

    private void print(){
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.println(Arrays.toString(gameBoard[i]));
        }
    }
}
