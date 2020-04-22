package tetris.app.main.basis.entity;

import java.util.Arrays;

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
        System.out.print("shape: ");
        for (int i = 0; i < shapeLocations.length; i++) {
            System.out.print(Arrays.toString(shapeLocations[i]));
        }
        System.out.println();
        return array2DClone(shapeLocations);
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

    public int[][] array2DClone(int[][] target){
        int[][] result = new int[4][2];
        for (int i = 0; i < target.length; i++) {
            result[i] = Arrays.copyOf(target[i], target[i].length);
        }
        return result;
    }
}
