/**
 * @title	Sudoku solver
 * @author	Arnas Kromelis
 * @date	10/29/2015
 * description	Solves a sudoku array using backtracking algorithm
 */
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
		System.out.print("Solving... ");
		
		emptyCell = getNextEmptyCell(0, 0);
		
		if ( !tryPosition( emptyCell[0], emptyCell[1] ) ) {
			System.out.println("\nThere is no solution!");
		}
	}

	private boolean tryPosition( int row, int col )
	{		
		//System.out.println("Row: " + row + " - Col: " + col);
			
		if( row == endRow ) {	// if its the last row 	
			System.out.println("Done!\n");
			printSudoku();
			return true;	// Finished
		} else {	// if its not the last row
			
			for (int i = 1 ; i <= endRow; i++){	// Get new numbers from 1..9
		        sudoku[row][col] = i;	// place the number in the position
		        if (OK(row, col)){ // Check if the number is OK in the position
		        	
		        	emptyCell = getNextEmptyCell(row, col);	// Get next empty cell
		        	
					if (emptyCell != null && tryPosition(emptyCell[0], emptyCell[1])) // Move to next empty cell
						return true;	// Finished
					
		        }
		    }
			
		    sudoku[row][col] = 0; // Empty cell
		    return false; // There is no solution	
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
	
	
	/*
	 * check if row, column and block doesn't have collisions
	 */
	private boolean OK(int row, int col) {
		
		return	checkRow(row) &&
				checkColumn(col) &&
				checkBlock(row-row%3, col-col%3);
	}
	
	private boolean checkRow(int row) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int col = 0; col < endRow; col++) {
			if (sudoku[row][col] != 0)
				if (list.contains(sudoku[row][col])) {
					return false;
				} else {
					list.add(sudoku[row][col]);
				}
		}
		
		return true;
	}


	private boolean checkColumn(int col) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int row = 0; row < endCol; row++) {
			if (sudoku[row][col] != 0)
				if (list.contains(sudoku[row][col])) {
					return false;
				} else {
					list.add(sudoku[row][col]);
				}
		}
		
		return true;
	}


	private boolean checkBlock(int blockRowStart, int blockColStart) {
		
		ArrayList<Integer> list = new ArrayList<>();
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < 3; i++) {
			row = i + blockRowStart;
			
			for (int j = 0; j < 3; j++) {
				col = j + blockColStart;
				
				if (sudoku[row][col] != 0)
					if (list.contains(sudoku[row][col])) {
						return false;
					} else {
						list.add(sudoku[row][col]);
					}
			}
		}
		
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