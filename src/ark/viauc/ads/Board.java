package ark.viauc.ads;

import java.util.ArrayList;

public class Board {

	public static final int BLOCKS_IN_ROW = 3;
	public static final int BLOCKS_IN_COLLUMN = 3;
	public static final int COLLUMNS_IN_BLOCK = 3;
	public static final int ROWS_IN_BLOCK = 3;
	public static final int CELLS_IN_BLOCK = COLLUMNS_IN_BLOCK * ROWS_IN_BLOCK; 
	public static final int TOTAL_NUMBER_OF_BLOCKS = BLOCKS_IN_COLLUMN * BLOCKS_IN_ROW; 
	public static final int TOTAL_NUMBER_OF_CELLS = TOTAL_NUMBER_OF_BLOCKS * CELLS_IN_BLOCK; 
	
	private ArrayList<Block> blocks;
	
	public Board() {
		blocks = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			blocks.add(new Block());
		}
	}
	
	public void insert2dArray(int[][] twoDimensionalArray) {
		
		ArrayList<Integer> convertedList = convert2dArray(twoDimensionalArray);
		
		int currentBlock = 0;
		int currentCell = 0;
		
		for (int i = 0; i < (((TOTAL_NUMBER_OF_BLOCKS) * BLOCKS_IN_ROW) * BLOCKS_IN_COLLUMN); i++) {
			currentBlock = i/3%3 + ((i/27%9) * BLOCKS_IN_ROW);
			currentCell = (i%3 + ((i/9%9) * ROWS_IN_BLOCK))%CELLS_IN_BLOCK;
			
			blocks.get(currentBlock).setCell(currentCell, convertedList.get(i));
			//System.out.println("Block: " + currentBlock + " - Cell: " + currentCell);
			
		}
	}
	
	private ArrayList<Integer> convert2dArray(int[][] twoDimensionalArray) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i=0; i < twoDimensionalArray.length; i++) {
			for (int j=0; j < twoDimensionalArray[i].length; j++) {
				list.add(twoDimensionalArray[i][j]);
			}
		}
		
		return list;
	}

	public Block getBlock(int block){
		return blocks.get(block);
	}
	
	public ArrayList<Block> getBlocks() {
		return blocks;
	}
	
	@Override
	public String toString() {
		String result = "------------------------- \n";
		
		int currentBlock = 0;
		int currentCell = 0;
		int number = 0;
		
		for (int i = 0; i < (((TOTAL_NUMBER_OF_BLOCKS) * BLOCKS_IN_ROW) * BLOCKS_IN_COLLUMN); i++) {
			currentBlock = i/3%3 + ((i/27%9) * BLOCKS_IN_ROW);
			currentCell = (i%3 + ((i/9%9) * ROWS_IN_BLOCK))%CELLS_IN_BLOCK;
			number = blocks.get(currentBlock).getCell(currentCell);
			
			if (i%9 == 0) result += "| ";
			
			if (number == 0)
				result += "- ";
			else
				result += blocks.get(currentBlock).getCell(currentCell) + " ";
			
			if (i%3 == 2) result += "| ";
			if (i%9 == 8) result += "\n";
			if (i%27 == 26) result += "------------------------- \n";
			
		}
		
		return result;
	}
	
}
