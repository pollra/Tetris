package tetris.app.main.basis.entity;

import tetris.app.main.basis.exception.HintException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description TetrisHint
 **********************************************************************************************************************/
public class TetrisHint {

    private List<Block> hints;
    private Random random;

    public TetrisHint() {
        this.hints = new ArrayList<>();
        this.random = new Random(System.currentTimeMillis());
        for (int i = 1; i <= 5; i++) {
            hints.add(castBlock(randomNumber()));
            random = new Random();
        }
    }

    private int randomNumber(){
        int[] hints = new int[5];
        random = new Random();
        for (int i = 0; i < hints.length; i++) {
            hints[i] = random.nextInt(Block.values().length-1);
            for (int j = 0; j < i; j++) {
                if(hints[i] == hints[j]){
                    i--;
                }else{
                    return hints[i];
                }
            }
        }
        return hints[0];
    }

    public Block currentHint(){
        return hints.get(0);
    }

    public Block next(){
        createNewHint();
        return currentHint();
    }

    private void createNewHint(){
        hints.remove(0);
        hints.add(castBlock(randomNumber()));
    }

    private Block castBlock(int randomNumber){
        Block[] blocks = Block.values();
        for (int i = 0; i < blocks.length; i++) {
            if(randomNumber == i){
                return blocks[i];
            }
        }
        throw new HintException("존재할 수 없는 힌트 입니다["+randomNumber+"]");
    }

}
