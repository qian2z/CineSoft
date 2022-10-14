/*
 * Ticket.java
 * qian2z final submission 19 Oct
 */
public class Ticket {

	private char rowLetter;
	private int seatNo;
	private boolean isOccupied;
	
	public Ticket() {
		
	}
	
	public Ticket(int rowIdx, int seatNo) {
		this.rowLetter = Hall.rowIndex2Letter(rowIdx);
		this.seatNo = seatNo;
		this.isOccupied = false;
	}
	
	public char getRowLetter() {
		return rowLetter;
	}
	
	public int getSeatNo() {
		return seatNo;
	}
	
	public boolean getIsOccupied() {
		return isOccupied;
	}
	
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	public String toString() {
		if(isOccupied) {
			return "XX";
		}
		else {
			return "" + rowLetter + seatNo;
		}
	}
}