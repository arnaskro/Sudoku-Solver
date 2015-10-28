package ark.viauc.ads;

import java.util.ArrayList;

public class Block {

	private ArrayList<Cell> cells;
	
	public Block() {
		cells = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			cells.add(new Cell());
		}
		
	}
	
	public void setCell(int cell, int number) {
		cells.get(cell).setNumber(number);
	}
	
	public int getCell(int cell) {
		return cells.get(cell).getNumber();
	}
	
	public int numberOfCells() {
		return cells.size();
	}
	
	public boolean checkBlockForNumber(int number) {
		
		for (int i = 0; i < cells.size(); i++) {
			if (cells.get(i).getNumber() == number) return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return cells.toString();
	}
		
}
