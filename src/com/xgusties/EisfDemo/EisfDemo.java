package com.xgusties.EisfDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.xgusties.EdinburghInternationalScienceFestival.Event;
import com.xgusties.EdinburghInternationalScienceFestival.Listings;
import com.xgusties.EdinburghInternationalScienceFestival.Venue;

public class EisfDemo {

	public static void main(String[] argv) {
		System.out.println("-- EisfDemo --");

		Venue venue = new Venue(38, "RGBE", null);
		
		Listings listings = new Listings(venue);
		System.out.println( "Found " + listings.getEvents().size() + " event(s).");
		
		List<Event> events = listings.getEvents();
		Iterator<Event> iterator = events.listIterator();		
		
		while (iterator.hasNext()) {
			Event event = (Event) iterator.next();
			
			SimpleDateFormat dateForamatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String startDate = dateForamatter.format(event.getStart());
			
			if (isDifferentDate(event.getStart(), event.getEnd())) {
				dateForamatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			} else {
				dateForamatter = new SimpleDateFormat("HH:mm");
			}
			String endDate = dateForamatter.format(event.getEnd());
			
			System.out.println( "-----------------------------" );
			System.out.println( "What: [" + event.getId() + "] " + event.getEventInfo() + " (" + startDate + " - " + endDate + ")" );
			System.out.println( "Where: " + event.getVenue().getName() );
			System.out.println( "Cost: " + event.getFullPrice() + " (concessions: " + event.getConcession() + ")");
			System.out.println( "About:" + event.getEventDesc() );


		}

	}
	
	public static Boolean isDifferentDate(Date date1, Date date2) {         

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date1Sting = dateFormat.format(date1); 
		String date2Sting = dateFormat.format(date2);
		//System.out.println(date1Sting);
		//System.out.println(date2Sting);
	    return date1Sting !=  date2Sting;                       

	 }
}
