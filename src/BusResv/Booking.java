package BusResv;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
	
	String passengerName;
	int busNo;
	Date date;
	
	Scanner sc = new Scanner(System.in);
	
	Booking(){
		System.out.println("Enter the Passenger Name : ");
		passengerName = sc.next();
		System.out.println("Enter the Bus No : ");
		busNo = sc.nextInt();
		System.out.println("Enter the date(dd-mm-yyyy) : ");
		String dateInput = 	sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isAvailable() throws SQLException {
		
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		
		int capacity = busdao.getCapacity(busNo);
		int bookedCount = bookingdao.getBookedCount(busNo,date);
		
		return bookedCount<capacity;
		
	}

}
