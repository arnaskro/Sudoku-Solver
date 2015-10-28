package ark.viauc.ads;

public class Cell {

	private int number;
	
	public Cell() {
		number = 0;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return number + "";
	}
	
}
