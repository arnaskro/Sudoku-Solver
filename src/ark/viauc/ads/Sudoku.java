package ark.viauc.ads;

public class Sudoku {

	/**
	 * Draws a sudoku board from the array
	 * 
	 * @param array		- 2d array with numbers [0-9]
	 * @return sudoku board with numbers from array in a String
	 */
	public static String drawSudoku(int[][] array) {
		String result = "\n-------------------------\n";
		
		if ( array != null ) {
			
			for (int i = 0; i < array.length; i++) {
				
				for (int j = 0; j < array[i].length; j++) {
					if (j%3 == 0) result += "| ";
					
					result += array[i][j] + " ";
					
					if (j == array[i].length-1) result += "| ";
				}
				
				if (i%3 == 2) result += "\n-------------------------";
				
				result += "\n";
			}
			
		}
		
		return result;
	}
	
}
