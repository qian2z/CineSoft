/*
 * Hall.java
 * qian2z final submission 19 Oct
 */
public class Hall {
	
	private String id;
	private int noRows;
	private int noSeats;
	private Ticket[][] tickets;
	private int numOfTickets;
	private int occupiedSeat = 0;
	
	public Hall() {
		
	}
	
	public Hall(String id) {
		this.id = id;
		
		if(id.substring(1, 2).equals("A")) {
			noRows = 9;
			noSeats = 10;
		}
		else if(id.substring(1, 2).equals("B")) {
			noRows = 15;
			noSeats = 8;
		}
		
		tickets = new Ticket[noRows][noSeats];
		
		for(int i = 0; i < tickets.length; i++) {
			for(int j = 0; j < tickets[i].length; j++) {
				tickets[i][j] = new Ticket(i, (j + 1));
			}
		}
		
		numOfTickets = noRows * noSeats;
	}
	
	public String getID() {
		return id;
	}
	
	public void setTicket(int rowIdx, int seatNo) {
		tickets[rowIdx][seatNo - 1].setIsOccupied(true);
		occupiedSeat++;
	}
	
	// check seat availability
	public boolean checkOccupied(int rowIdx, int seatNo) {
		return tickets[rowIdx][seatNo - 1].getIsOccupied();
	}
	
	public int getNoSeats() {
		return noSeats;
	}
	
	public int getNoRows() {
		return noRows;
	}
	
	// Note: this static method is given
	// Converts row letter (char) to index number (int)
	public static int rowLetter2Idx(char letter) {
		return (int)(letter)-65;
	}
	
	// Note: this static method is given
	// Converts index number (int) to row letter (char)
	public static char rowIndex2Letter(int idx) {
		return (char)(idx+'A');
	}
	
	//occupied seat display
	public String seatDisplay() {
		String printHall;
		printHall = toString();
		for(int i = 0; i < tickets.length; i++) {
			for(int j = 0; j < tickets[i].length; j++) {
				printHall += tickets[i][j] + " ";
			}
			printHall += "\n";
		}
		printHall += "'XX' : Seat Not Available\n";
		return printHall;
	}
	
	public boolean checkHallAvailability() {
		if((numOfTickets - occupiedSeat) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// print availability
	public String toString() {
		String availability;
		availability = "Hall " + getID() + " Seating Availability: " + (numOfTickets - occupiedSeat) + " / " + numOfTickets + "\n";
		return availability;
	}
	
}
