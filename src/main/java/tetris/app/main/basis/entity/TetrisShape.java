package tetris.app.main.basis.entity;

import tetris.app.main.tools.MyArrays;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description TetrisBlock
 **********************************************************************************************************************/
public class TetrisShape {

    private int[][] shapeLocations;

    public TetrisShape(Block block) {
        this.shapeLocations = block.getDefaultLocation();
    }

    public int[][] currentShapePrinter(){
        return MyArrays.clone2D(shapeLocations);
    }

    public void rotateRight() {
        for (int x = 0; x < shapeLocations.length; x++) {
            if(shapeLocations[x][0] <= 1 && shapeLocations[x][1] <= 1)
                shapeLocations[x][0] = shapeLocations[x][0] * -1;
            swapTwoValuesInAnArray(shapeLocations[x]);
        }
    }

    private void swapTwoValuesInAnArray(int[] block){
        int temp = block[0];
        block[0] = block[1];
        block[1] = temp;
    }
}
