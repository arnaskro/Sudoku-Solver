package ark.viauc.ads;

import java.util.ArrayList;

public class Solver {
	
	public static final int BLOCKS_IN_ROW = 3;
	public static final int BLOCKS_IN_COLLUMN = 3;
	public static final int COLLUMNS_IN_BLOCK = 3;
	public static final int ROWS_IN_BLOCK = 3;
	public static final int CELLS_IN_BLOCK = COLLUMNS_IN_BLOCK * ROWS_IN_BLOCK; 
	public static final int TOTAL_NUMBER_OF_BLOCKS = BLOCKS_IN_COLLUMN * BLOCKS_IN_ROW; 
	public static final int TOTAL_NUMBER_OF_CELLS = TOTAL_NUMBER_OF_BLOCKS * CELLS_IN_BLOCK; 
	
	
	private static Board solve(Board board) {
		
		ArrayList<Block> blocks = board.getBlocks();
		
		int currentBlock = 0;
		int currentCell = 0;
		
		int cell = 0;
		
		for (int i = 0; i < (((TOTAL_NUMBER_OF_BLOCKS) * BLOCKS_IN_ROW) * BLOCKS_IN_COLLUMN); i++) {
			currentBlock = i/3%3 + ((i/27%9) * BLOCKS_IN_ROW);
			currentCell = (i%3 + ((i/9%9) * ROWS_IN_BLOCK))%CELLS_IN_BLOCK;
			
			cell = blocks.get(currentBlock).getCell(currentCell);
		}
		
		return null;
	}
		
	public static Board solveBoard(Board board) {
		return solve(board);
	}
	
	public static String solveBoard(int[][] twoDimensionalArray) {
		Board board = new Board();
		board.insert2dArray(twoDimensionalArray);
		
		return solveBoard(board).toString();		
	}
	
}
