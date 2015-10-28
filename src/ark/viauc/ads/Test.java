package ark.viauc.ads;

public class Test {

	public static void main(String[] args) {
		System.out.println("// Sudoku Solver");
		
		int[][] array = 
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
		
		Board board = new Board();
		board.insert2dArray(array);
		
		System.out.println("\nUnsolved: ");
		System.out.println(board.toString());
		
		System.out.println("Solved: ");
		System.out.println(Solver.solveBoard(board));
	}

}
