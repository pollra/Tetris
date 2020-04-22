package tetris.app.main.basis.entity;

import tetris.app.main.basis.exception.BlockException;
import tetris.app.main.tools.MyArrays;

import java.util.Arrays;

import static tetris.app.main.basis.entity.Direction.*;
/**
 * @since       2020.04.13
 * @author      pollra
 * @description TetrisBlock
 **********************************************************************************************************************/
public class TetrisBlock {
    private static final int WIDTH_MAX = 10;
    private static final int WIDTH_MIN = 1;
    private static final int HEIGHT_MAX = 22;
    private static final int HEIGHT_MIN = 0;

    private static final int[][] DEFAULT_GAME_BOARD = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private static final int[] DEFAULT_BLOCK_LOCATION = {1, 5};

    private int[][] blockSpace;
    private int[] currentLocation;
    private int[] testLocation;
    private TetrisShape tetrisShape;
    private Block currentBlock;

    public TetrisBlock(Block block) {
        this.currentBlock = block;
        this.tetrisShape = new TetrisShape(this.currentBlock);
        this.blockSpace = MyArrays.clone2D(DEFAULT_GAME_BOARD);
        this.currentLocation = Arrays.copyOf(DEFAULT_BLOCK_LOCATION, DEFAULT_BLOCK_LOCATION.length);
        this.testLocation = Arrays.copyOf(DEFAULT_BLOCK_LOCATION, DEFAULT_BLOCK_LOCATION.length);
    }

    public void newBlock(Block block){
        this.currentBlock = block;
        this.blockSpace = MyArrays.clone2D(DEFAULT_GAME_BOARD);
        this.currentLocation = Arrays.copyOf(DEFAULT_BLOCK_LOCATION, DEFAULT_BLOCK_LOCATION.length);
        this.tetrisShape = new TetrisShape(currentBlock);
    }

    public int[][] createMockBlockSpaceTo(Direction move){
        this.testLocation = this.currentLocation.clone();
        locationMove(testLocation, move);
        int[][] shape = MyArrays.clone2D(tetrisShape.currentShapePrinter());
        return combinationBlockSpace(shape);
    }

    public void realMove(Direction move){
        locationMove(currentLocation, move);
    }

    private void locationMove(int[] location, Direction direction){
        final int HEIGHT = 0;
        final int WIDTH = 1;
        switch (direction){
            case LEFT:
                if(location[WIDTH] <= WIDTH_MIN) break;
                location[WIDTH] -= 1;
                return;
            case RIGHT:
                if(location[WIDTH] >= WIDTH_MAX) break;
                location[WIDTH] += 1;
                return;
            case DOWN:
                if(location[HEIGHT] >= HEIGHT_MAX) break;
                location[HEIGHT] += 1;
                return;
            case CURRENT:
                location = currentLocation.clone();
                return;
            default: break;
        }
        throw new BlockException("해당 방향으로 더 움직일 수 없습니다"+direction.name());
    }

    private int[][] combinationBlockSpace(int[][] shape){
        int[][] blockSpace = MyArrays.clone2D(DEFAULT_GAME_BOARD);
        for (int i = 0; i < shape.length; i++) {
            blockSpace[shape[i][0]+testLocation[0]]
                    [shape[i][1]+testLocation[1]]
                    = currentBlock.getColor().getNumber();
        }
        return blockSpace;
    }

    private int[][] sumLocationShape(int[] location, int[][] shape){
        int[][] result = MyArrays.clone2D(shape);
        for (int i = 0; i < shape.length; i++) {
            result[i][0] += location[0];
            result[i][1] += location[1];
        }
        return result;
    }

    public int[][] getBlockLocationShape(){
        int[][] shape = MyArrays.clone2D(tetrisShape.currentShapePrinter());
        return sumLocationShape(testLocation, shape);
    }

    public int getCurrentColor(){
        return currentBlock.getColor().getNumber();
    }

    public void transform(){
        tetrisShape.rotateRight();
    }





    private void printfBlockSpace(){
        for (int[] item : this.blockSpace){
            System.out.println(Arrays.toString(item));
        }
    }

    private void spaceClean(){
        int[][] defaultGameBoard = MyArrays.clone2D(DEFAULT_GAME_BOARD);
        for (int x = 0; x < defaultGameBoard.length; x++) {
            for (int y = 0; y < defaultGameBoard[x].length; y++) {
                blockSpace[x][y] = defaultGameBoard[x][y];
            }
        }
    }
}
