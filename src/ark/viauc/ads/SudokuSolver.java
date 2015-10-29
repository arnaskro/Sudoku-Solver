package ark.viauc.ads;

import java.util.ArrayList;

public class SudokuSolver
{
	public static void main( String[] args )
	{
		new SudokuSolver().run();
	}
			
	private int[][] sudoku = 
		{
				{8, 0, 0,  7, 0, 0,  0, 0, 0},
				{0, 0, 9,  0, 4, 0,  7, 0, 1},
				{0, 5, 1,  0, 6, 0,  0, 0, 3},
				
				{0, 8, 0,  1, 0, 0,  0, 0, 6},
				{0, 0, 0,  0, 0, 0,  0, 0, 0},
				{1, 0, 0,  0, 0, 5,  0, 8, 0},
				
				{6, 0, 0,  0, 1, 0,  9, 7, 0},
				{4, 0, 7,  0, 3, 0,  6, 0, 0},
				{0, 0, 0,  0, 0, 2,  0, 0, 8}
		};
	
	private int endRow = sudoku.length;
	private int endCol = sudoku[endRow-1].length;
	private int[] emptyCell;	
	
	private void run()
	{		
		printSudoku();

		solve();
	}
	
	
	private void solve() {
		emptyCell = getNextEmptyCell(0, 0);
		
		if ( !tryPosition( emptyCell[0], emptyCell[1] ) ) {
			System.out.println("Solution not found!");
		}
	}


	private boolean tryPosition( int row, int col )
	{		
		//System.out.println("Row: " + row + " - Col: " + col);
			
		if( row == endRow ) {			
			printSudoku();
			return true;
		} else {
			
			for (int i = 1 ; i < endRow+1; i++){	// Get new numbers
		        sudoku[row][col] = i;
		        if (OK()){ // Check if there is no collisions
		        	
		        	emptyCell = getNextEmptyCell(row, col);	// Get next empty cell
		        	
					if (emptyCell != null && tryPosition(emptyCell[0], emptyCell[1])) // Move to next empty cell
						return true;	// Finished
					
		        }
		    }
			
		    sudoku[row][col] = 0; // Undo cell;
		    return false; //Solution not found. Backtrack.			
		}
	}
	
	private int[] getNextEmptyCell(int row, int col) {
		int[] position = new int[2];
		
		for (int i = row; i < endRow; i++) {	// Check row
		
			for (int j = col+1; j < endCol; j++) {	// Check column
				if (sudoku[i][j] == 0) {	// If cell is empty
					position[0] = i;	// Insert row
					position[1] = j;	// Insert column
					
					return position;	// Return array with results
				}
			}
			
			col = -1;	// Reset column. (-1 because we do +1 in the loop)
		}
		
		// no more empty cells
		position[0] = 9;	// Insert last row
		position[1] = 0;	// This doesn't matter
		
		return position;
	}
	
	private boolean OK() {
		
		return	checkRows() &&
				checkCollumns() &&
				checkBlocks();
	}
		
	private boolean checkRows() {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < endRow; i++) {
			for (int j = 0; j < endCol; j++) {
				if (sudoku[i][j] != 0) {
					if (!list.contains(sudoku[i][j])) {
						list.add(sudoku[i][j]);
					} else {
						return false;
					}
				}
			}
			
			list.clear(); // Clear list. Prepare for next row 
		}
		
		return true;
	}


	private boolean checkCollumns() {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < endCol; i++) {
			for (int j = 0; j < endRow; j++) {
				if (sudoku[j][i] != 0) {
					if (!list.contains(sudoku[j][i])) {
						list.add(sudoku[j][i]);
					} else {
						return false;
					}
				}
			}
			
			list.clear(); // Clear list. Prepare for next row 
		}
		
		return true;
	}


	private boolean checkBlocks() {
		// TODO Auto-generated method stub
		return true;
	}


	private void printSudoku()
	{
		System.out.println("-------------------------");
		
		for( int i = 0; i < sudoku.length; ++i ) {
			
			System.out.print("| ");
			
			for( int j = 0; j < sudoku[i].length; ++j ) {
				
				System.out.print( sudoku[i][j] + " " );
				
				if (j%3 == 2) System.out.print("| ");
			}
			
			if (i%3 == 2) System.out.println("\n-------------------------");
			else System.out.println();
			
		}
		System.out.println();
	}
}