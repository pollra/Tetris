package tetris.app.main.tools;

import java.util.Arrays;

/**
 * @since       2020.04.21
 * @author      pollra
 * @description MyArrays
 **********************************************************************************************************************/
public class MyArrays {
    public static int[][] clone2D(int[][] target){
        int[][] result = new int[24][12];
        for (int i = 0; i < target.length; i++) {
            result[i] = Arrays.copyOf(target[i], target[i].length);
        }
        return result;
    }

    public static void print(int[][] arr){
        System.out.print(": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
