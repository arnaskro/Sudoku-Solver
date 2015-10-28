package ark.viauc.ads;

import java.util.ArrayList;

public class Solver {
	
	final static int[] NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	protected boolean checkAll(int[][] array) {
		
		for ( int i = 0 ; i < array.length; i++) {
			if (!checkInRow(i, 0) || !checkInColumn(i, 0))	return false;	
		}
		
		return true;
	}
	
	private boolean checkInColumn(int column, int numberToCheck) {
		
		return false;
	}
	
	private boolean checkInRow(int row, int numberToCheck) {
		
		return false;
	}
	
	/**
	 * Return true if the number was found, return false if it wasnt
	 */
	private boolean checkInBlock(int block, int numberToCheck) {
		
		
		return false;
	}
	
	private int[] getPossibleFromBlock(int block) {
		ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();
		
		for (int i = 0; i < NUMBERS.length; i++) {
			if (!checkInBlock(block, NUMBERS[i])) possibleNumbers.add(NUMBERS[i]);
		}
		
		return toPrimitive(possibleNumbers.toArray(new Integer[possibleNumbers.size()]));
	}
	
	public static int[] toPrimitive(Integer[] IntegerArray) {

		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}
}
