/**
 * Software Development A, Coursework 2
 * 
 * The coursework specification is provided in Canvas.
 * Please read through it in full before you start work.
 * 
 * @author qian2z final submission 19 Oct
 */
import java.util.Scanner;

public class CineSoft {

	public static void main(String[] args) {
		// ***** DO NOT CHANGE THIS PART OF THE CODE *****
		// 6 shows are currently showing in the 6 different halls of the cinema
		Show [] shows = new Show[6];  
		shows[0] = new Show("2B", new Movie("Shang-Chi and the Legend of the Ten Rings", "PG-13", 2)); 
		shows[1] = new Show("3A", new Movie("Dune", "PG-13", 3)); 
		shows[2] = new Show("1B", new Movie("Squid Game The Movie", "PG-15", 2)); 
		shows[3] = new Show("4A", new Movie("Shang-Chi and the Legend of the Ten Rings", "PG-13", 3)); 
		shows[4] = new Show("5A", new InternationalMovie("Deux Fils", "U", 2, "French")); 
		shows[5] = new Show("6B", new InternationalMovie("Druk", "U", 1, "Danish")); 
		System.out.println("*** WELCOME TO CINESOFT MOVIE BOOKING SYSTEM ***\n");
		///////////////////////////////////////////////////////////////////////////////////

		// ticket booking loop
		Scanner scan = new Scanner(System.in);
		String checkContinue;
		
		do {
			boolean checkIndex = false;
			int index = 0;
			while(!checkIndex) {
				try {
					System.out.println("\nPress the index number to book: ");
					int i = 0;
					
					for(Show element : shows) {
						System.out.println("#" + i + ": " + element);
						i++;
					}
					
					System.out.print(">> ");
					index = scan.nextInt();
					System.out.println("\n>>> " + shows[index]);
					checkIndex = true;
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.err.println("Invalid Index Number. Please Try Again!\n");
				}
			}
			
			// book multiple tickets each time
			System.out.println("How many tickets do you want to book? ");
			System.out.print(">> ");
			int numTickets = scan.nextInt();
			
			String bookedTickets = " ";
			System.out.println("\n>>> " + shows[index]);
			shows[index].printHall();
			
			for(int i = 1; i <= numTickets; i++) {
				char rowLetter = 0;
				int seatNum = 0;
				boolean checkSeat = false;
				while(!checkSeat) {
					try {
						
						// check seat availability
						do {
							System.out.println("Ticket " + i + ": " + shows[index].ask4SeatLocationStatement());
							System.out.print(">> ");
							rowLetter = scan.next().charAt(0);
							seatNum = scan.nextInt();
							if(!shows[index].checkSeatAvailability(rowLetter, seatNum)) {
								System.err.println("" + rowLetter + "" + seatNum + " is Not Available. Please Enter Other Seats.\n");
							}
						}
						while(!shows[index].checkSeatAvailability(rowLetter, seatNum));
						
						shows[index].buyTicket(rowLetter, seatNum);
						bookedTickets += "" + rowLetter + "" + seatNum;
						checkSeat = true;
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.err.println("Invalid Seat. Please Try Again!\n");
					}
				}
				bookedTickets += " ";
			}
			
			System.out.println("\n" + numTickets + " ticket(s): " + bookedTickets + " are successfully booked.");
			System.out.println("\n>>> " + shows[index]);
			shows[index].printHall();
			
			System.out.println("Do you wish to continue (y/n) ?");
			System.out.print(">> ");
			checkContinue = scan.next();
		}
		while(checkContinue.equalsIgnoreCase("Y"));
		
		// list availability of seats for each movie/hall
		System.out.println();
		for(Show element : shows) {
			element.printAvailability();
		}
		
	}

}
