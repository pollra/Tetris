package tetris.app.main.basis.service;

import tetris.app.main.basis.entity.*;
import tetris.app.main.basis.exception.BusinessException;
import tetris.app.main.tools.MyArrays;

/**
 * @since       2020.03.29
 * @author      pollra
 * @description TetrisMapService
 **********************************************************************************************************************/
public class TetrisServiceImpl implements TetrisService{

    private TetrisBoard board;
    private TetrisBlock block;
    private TetrisHint hint;

    private int wallDownCount = 0;

    public TetrisServiceImpl() {
        this.board = new TetrisBoard();
        this.hint = new TetrisHint();
        this.block = new TetrisBlock(hint.currentHint());
    }

    @Override
    public int[][] transform() {
        System.out.println("transform order start");
        block.transform();
        try {
            int[][] mockBlock = block.createMockBlockSpaceTo(Direction.CURRENT);
            int[][] boardSpace = board.getCombinationBoard(mockBlock);
            return board.combinationCheck(boardSpace, block.getBlockLocationShape(), block.getCurrentColor());
        }catch(BusinessException e){
            block.transformRollBack();
            throw new BusinessException("변형 불가한 영역 입니다");
        }
    }

    @Override
    public int[][] leftMove() {
        System.out.println("leftMove order start");
        int[][] mockBlock = block.createMockBlockSpaceTo(Direction.LEFT);
        int[][] boardSpace = board.getCombinationBoard(mockBlock);
        int[][] result = board.combinationCheck(boardSpace, block.getBlockLocationShape(), block.getCurrentColor());
        block.realMove(Direction.LEFT);
        return result;
    }

    @Override
    public int[][] rightMove() {
        System.out.println("rightMove order start");
        int[][] mockBlock = block.createMockBlockSpaceTo(Direction.RIGHT);
        int[][] boardSpace = board.getCombinationBoard(mockBlock);
        int[][] result =  board.combinationCheck(boardSpace, block.getBlockLocationShape(), block.getCurrentColor());
        block.realMove(Direction.RIGHT);
        return result;
    }

    private int[][] downMoveAuto() {
        int[][] mockBlock = block.createMockBlockSpaceTo(Direction.DOWN);
        int[][] boardSpace = board.getCombinationBoard(mockBlock);
        int[][] result = MyArrays.clone2D(
                board.combinationCheck(
                        boardSpace,
                        block.getBlockLocationShape(),
                        block.getCurrentColor()
                )
        );
        block.realMove(Direction.DOWN);
        return result;
    }

    @Override
    public int[][] downMove() {
        int[][] result;
        try {
            result = downMoveAuto();
        }catch (BusinessException e){
            System.out.println(e.getMessage());
            board.save(block.getCurrentBlockSpace());
            block.newBlock(hint.next());
            result = board.getCombinationBoard(board.currentBoardPrint());
        }
        return result;
    }

    private int[][] currentBoard(){
        int[][] mockBlock = block.createMockBlockSpaceTo(Direction.CURRENT);
        int[][] boardSpace = board.getCombinationBoard(mockBlock);
        return board.combinationCheck(boardSpace, block.getBlockLocationShape(), block.getCurrentColor());
    }

    @Override
    public int[][] fastDown() {
        System.out.println("fastDown order start");
        for (int i = 0; i < 22; i++) {
            try {
                downMoveAuto();
            }catch (BusinessException e){
                return downMove();
            }
        }
        return downMove();
    }

    @Override
    public int[][] stop() {
        System.out.println("stop order start");
        return null;
    }


}
