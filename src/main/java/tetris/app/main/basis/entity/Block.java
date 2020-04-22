package tetris.app.main.basis.entity;

import tetris.app.main.tools.MyArrays;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description Tetris Block
 **********************************************************************************************************************/
public enum Block {
    L(new int[][]{{-1, 0}, {0, 0}, {1, 0}, {1, 1}}   , Color.RED),
    J(new int[][]{{-1, 0}, {0, 0}, {1, 0}, {1, -1}}  , Color.ORANGE),
    Z(new int[][]{{-1, 0}, {0, 0}, {-1, -1}, {0, 1}} , Color.YELLOW),
    S(new int[][]{{-1, 0}, {0, 0}, {-1, 1}, {0, -1}} , Color.GREEN),
    T(new int[][]{{-1, 0}, {0, 0}, {0, 1}, {0, -1}}  , Color.SKY),
    O(new int[][]{{-1, 0}, {0, 0}, {0, 1}, {-1, -1}} , Color.BLUE),
    I(new int[][]{{-1, 0}, {0, 0}, {1, 0}, {2, 0}}   , Color.PURPLE);

    private int[][] defaultLocation;
    private Color color;

    Block(int[][] defaultLocation, Color color) {
        this.color = color;
        this.defaultLocation = defaultLocation;
    }

    public int[][] getDefaultLocation() {
        return MyArrays.clone2D(this.defaultLocation);
    }

    public Color getColor() {
        return color;
    }

}
