/*
 * Show.java
 * qian2z final submission 19 Oct
 */
public class Show {

	private Movie movie;
	private Hall hall;
	
	public Show() {
		
	}
	
	public Show(String hallID, Movie movie) {
		this.hall = new Hall(hallID);
		this.movie = movie;
	}
	
	public void buyTicket(char row, int seatNo) {
		hall.setTicket(Hall.rowLetter2Idx(row), seatNo);
	}
	
	// check seat availability
	public boolean checkSeatAvailability(char row, int seatNo) {
		if(hall.checkOccupied(Hall.rowLetter2Idx(row), seatNo)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String toString() {
		String printMenu = "";
		String language = null;
		
		if(movie.getClass().getName().equals("Movie")) {
			language = "";
		}
		else if(movie.getClass().getName().equals("InternationalMovie")) {
			language = " (" + ((InternationalMovie) movie).getLanguage() + ")";
		}
		
		printMenu += String.format("%-18s", movie.getSession()) + hall.getID() + "  " + String.format("%-5s", movie.getRating()) + " " + movie.getTitle() + language;
		
		if(!hall.checkHallAvailability()) {
			printMenu += " SOLD OUT";
		}
		
		return printMenu;
	}
	
	public String ask4SeatLocationStatement() {
		return "Enter row letter (A-" + (Hall.rowIndex2Letter(hall.getNoRows() - 1)) + ") and seat number (1-" + hall.getNoSeats() + ")";
	}
	// occupied seat display
	public void printHall() {
		System.out.println(this.hall.seatDisplay());
	}
	
	public void printAvailability() {
		System.out.print(hall);
	}
}