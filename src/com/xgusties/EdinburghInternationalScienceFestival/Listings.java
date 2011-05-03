package com.xgusties.EdinburghInternationalScienceFestival;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Listings {

	private static final String FEED_URL = "http://projects.festivalslab.com/eisf/api/v1/listings.json";

	private ArrayList<Event> events;
	
	public Listings () {
		super();				
		HashMap<String,String> params = new HashMap<String,String>(); //empty
		ArrayList<Event> events = getEventsFromFeed(params);
		setEvents(events);
	}
	
	public Listings(Venue venue) {
		super();				
		HashMap<String,String> params = new HashMap<String,String>();
		params.put("venue_id",venue.getId().toString());

		ArrayList<Event> events = getEventsFromFeed(params);
		setEvents(events);
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}
	private void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	private static ArrayList<Event> getEventsFromFeed(HashMap<String,String> searchTerms) {		

		//PostMethod post = new PostMethod(FEED_URL);
		String queryString = "";
		//post.setFollowRedirects(true);
		
		ArrayList<Event> events = new ArrayList<Event>();
		for (Map.Entry<String, String> searchTerm : searchTerms.entrySet()) {
			//post.addParameter(searchTerm.getKey(), searchTerm.getValue());
			queryString += searchTerm.getKey() + "=" + searchTerm.getValue() + "&";
		}
		//post.addParameter("results","2");
		//queryString += "results=2&";

		GetMethod get = new GetMethod(FEED_URL + "?" + queryString);

		//RequestEntity entity = new FileRequestEntity(xmlString, "text/xml; charset=ISO-8859-1");
		//post.setRequestEntity(entity);

		HttpClient client = new HttpClient();
		try {
			//int status = client.executeMethod(post);
			@SuppressWarnings("unused")
			int status = client.executeMethod(get);
			//String rawData = post.getResponseBodyAsString();
			String rawData = get.getResponseBodyAsString();
			String tweakedData = "{festival: " + rawData + "}";
			//System.out.println();
			//System.exit(0);
			JSONObject jsonData = new JSONObject(tweakedData);
			JSONArray jsonEvents = jsonData.getJSONArray("festival");
			
			Integer eventCount = jsonEvents.length();
			//eventCount = 1;
			for (int i = 0; i < eventCount; i++) {
				JSONObject eventData = jsonEvents.getJSONObject(i);
				//System.out.println(eventData.toString());
				
				Event event = new Event();
				
				event.setId(eventData.optString("event_id"));

				event.setEventInfo(eventData.optString("Event_Info"));
				event.setEventDesc(eventData.optString("Event_Desc"));

				event.setMinimumAge(eventData.optInt("Minimum_age"));
				event.setMaximumAge(eventData.optInt("Maximum_age"));

//				String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (epoch*1000));
				Long start = eventData.optLong("start_timestamp");
				Long end = eventData.optLong("end_timestamp");
				event.setStart( new Date(start*1000) ); //Date takes milliseconds
				event.setEnd( new Date(end*1000) );

				Integer venueId = eventData.optInt("Venue_ID");
				String venueName = eventData.optString("Venue");
				String subVenue = eventData.optString("Sub_Venue");				
				Integer capacity = eventData.optInt("Capacity");				
				if (subVenue != "" && subVenue != null) {
					event.setVenue(new SubVenue(venueId, venueName, capacity, subVenue));
				} else {
					event.setVenue(new Venue(venueId, venueName, capacity));
				}

				event.setTypeOfEvent(eventData.optString("Type_of_Event"));			
				event.setConfirmedTheme(eventData.optString("Confirmed_Theme"));

				//TODO - check if this is needed.
				//can this be deduced from getMinimumAge() and getMaximimAge()?
				event.setAudience(eventData.optString("Audience"));
				
				event.setEventCode(eventData.optString("Event_Code"));
				event.setEventCategory(eventData.optString("Event_Category"));

				event.setOrganisedBy(new Organisation(eventData.optString("Organised_by")));
				event.setPromoter(new Organisation(eventData.optString("Promoter")));
				event.setSpeakerName(new Person(eventData.optString("Speaker_Name")));
				event.setSupportedBy(new Person(eventData.optString("Supported_by")));

				event.setFullPrice(eventData.optString("Full_Price"));
				event.setConcession(eventData.optString("Concession"));
				event.setTicketsAvailableFrom(eventData.optString("tickets_available_from"));

				event.setFestival(eventData.optString("festival"));
				event.setEisfTicket(eventData.optBoolean("EISF_Ticket"));
				
				events.add(event);
			}
			System.out.println();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//post.releaseConnection();
			get.releaseConnection();
		}
		
//		
//		HttpClient client = new HttpClient();
//		try {
//			int status = client.executeMethod(post);
//		} catch (HttpException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		try {
//			String response = post.getResponseBodyAsString();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
		return events;
	}



//
//	private Date start; // The earliest time to return.
//	//For example: "now", "October 15", "Oct 15 9am".
//
//	private Date end; // The latest time to return.
//	//For example: "tomorrow 3pm", "October 15", "Oct 15 9am".
//
//	private String event_desc; // Only return results with the specified value in the event title.
//	//For example: "quantum theory" will only return events with "quantum theory" in the title.
//
//	private String event_info; // Only return results with the specified value in the event description.
//	//For example: "physics" will only return events with "physics" in the event description.
//
//	private String confirmed_theme; // Search for events with a particular theme.
//
//	private String event_category; // Search for events within a particular category.
//
//	private String venue; // Only return results with the specified venue name. Use this to find other events in the same venue as an event you have already found.
//
//	private String venue_id; // Only return results with the specified venue ID. Use this to find other events in the same venue as an event you have already found.
//
//	private String event_id; // Find events with a particular venue ID. Use this to link together events that recur over different days.
//
//	private Integer results; // The number of results to return; must be an integer value. If omitted, all relevant events will be returned.
//	//For example: "5".
//
//	private String order; // Specifies how events will be ordered in the field.
//	//Either "alpha" or "date"; defaults to date order.

}
