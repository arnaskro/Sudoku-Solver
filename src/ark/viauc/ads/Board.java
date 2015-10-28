package ark.viauc.ads;

import java.util.ArrayList;

public class Board {

	private ArrayList<Block> blocks;
	
	public Board() {
		blocks = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			blocks.add(new Block());
		}
	}
	
	public void insert2dArray(int[][] twoDimensionalArray) {
		
		Block block = null;
		
		for (int i = 0; i < 9; i++) {
			block = blocks.get(i);
			
			for (int j = 0; j < 9; j++) {
				block.setCell(j, twoDimensionalArray[i][j]);
			}
			
		}
		
	}
	
	
	@Override
	public String toString() {
		String result = "\n-------------------------\n";
		
		int number = 0;
		
		if ( blocks != null ) {
			
			for (int i = 0; i < blocks.size(); i++) {
				
				for (int j = 0; j < blocks.get(i).numberOfCells(); j++) {
					if (j%3 == 0) result += "| ";
					
					number = blocks.get(i).getCell(j);
					
					if (number != 0)					
						result += number + " ";
					else 
						result += "- ";
					
					if (j == blocks.get(i).numberOfCells()-1) result += "| ";
				}
				
				if (i%3 == 2) result += "\n-------------------------";
				
				result += "\n";
			}
			
		}
		
		return result;
	}
	
}
