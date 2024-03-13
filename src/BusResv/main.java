package BusResv;

import java.sql.SQLException;
import java.util.Scanner;

public class main {

	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		BusDAO busdao = new BusDAO();
		try {
			
			busdao.displayBusInfo();
			
			while(true) {
				System.out.println("Enter you options ");
				System.out.println("1.Book a Bus");
				System.out.println("2.Exit");
				int userOpt = sc.nextInt();
				switch(userOpt) {
				case 1:
					Booking book = new Booking();
					if(book.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(book);
						System.out.println("Your Booking is confirmed...");
					}
					else {
						System.out.println("Sorry! Opted Bus is not available...Try another Bus");
					}
					break;
				case 2:
					System.exit(userOpt);
					break;
				default:
					System.out.println("Invalid Option");
					break;
				}
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
