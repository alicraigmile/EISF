package com.xgusties.EdinburghInternationalScienceFestival;

import java.util.Date;

public class Event {

	private String id;

	private Source source;
	private Area area;
	private String eventDesc;
	private String eventCode;
	private String eventCategory;
	private Venue venue;
	private String typeOfEvent;
	private String confirmedTheme;
	private String audience;
	private String mainClass;
	private String eventInfo;
	private Date start;
	private Date end;
	private Performance[] performances;
	private Integer minimumAge;
	private Integer maximumAge;

	private Agent organisedBy;
	private Agent promoter;
	private Agent speakerName;
	private Agent supportedBy;

	private String fullPrice;
	private String concession;
	private String ticketsAvailableFrom;

	private String festival;
	private Boolean eisfTicket;

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getTypeOfEvent() {
		return typeOfEvent;
	}

	public void setTypeOfEvent(String typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}

	public String getConfirmedTheme() {
		return confirmedTheme;
	}

	public void setConfirmedTheme(String confirmedTheme) {
		this.confirmedTheme = confirmedTheme;
	}

	public String getAudience() {
		return audience;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public Agent getOrganisedBy() {
		return organisedBy;
	}

	public void setOrganisedBy(Agent organisedBy) {
		this.organisedBy = organisedBy;
	}

	public Agent getPromoter() {
		return promoter;
	}

	public void setPromoter(Agent promoter) {
		this.promoter = promoter;
	}

	public Agent getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(Agent speakerName) {
		this.speakerName = speakerName;
	}

	public Agent getSupportedBy() {
		return supportedBy;
	}

	public void setSupportedBy(Agent supportedBy) {
		this.supportedBy = supportedBy;
	}

	public String getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(String fullPrice) {
		this.fullPrice = fullPrice;
	}

	public String getConcession() {
		return concession;
	}

	public void setConcession(String concession) {
		this.concession = concession;
	}

	public String getTicketsAvailableFrom() {
		return ticketsAvailableFrom;
	}

	public void setTicketsAvailableFrom(String ticketsAvailableFrom) {
		this.ticketsAvailableFrom = ticketsAvailableFrom;
	}

	public String getFestival() {
		return festival;
	}

	public void setFestival(String festival) {
		this.festival = festival;
	}

	public Boolean getEisfTicket() {
		return eisfTicket;
	}

	public void setEisfTicket(Boolean eisfTicket) {
		this.eisfTicket = eisfTicket;
	}

	public Integer getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(Integer minimumAge) {
		this.minimumAge = minimumAge;
	}
	
	public Integer getMaximumAge() {
		return maximumAge;
	}

	public void setMaximumAge(Integer maximumAge) {
		this.maximumAge = maximumAge;
	}
	
	public Integer getCapacity() {
		return this.getVenue().getCapacity();
	}

	public Event() {
		super();
	}
	
	//{"Datecode":"09/04/2011 10:00",
	//"end_timestamp":"1302364800",
	//"event_id":"eisf2011_154",
	//"Event_Info":"Natural Chemists",
	//"Maximum_age":"",
	//"Organised_by":"With RBGE, and the University of Edinburgh",
	//"Venue":"RGBE",
	//"Type_of_Event":"Science Festival Families",
	//"Date":"09/04",
	//"Finish_Time":"17:00",
	//"Audience":"5+",
	//"Event_Code":"NATURALC",
	//"Duration":"Drop in",
	//"Concession":"",
	//"Speaker_Name":"",
	//"Event_Category":"ACTIVITY",
	//"festival":"eisf2011",
	//"Full_Price":"Free (no ticket required)",
	//"start_timestamp":"1302339600",
	//"Minimum_age":"5",
	//"Promoter":"EISF",
	//"Supported_by":"",
	//"Confirmed_Theme":"Natural World",
	//"tickets_available_from":"not required",
	//"Venue_ID":"38",
	//"Sub_Venue":"Real Life Science Studio",
	//"Capacity":"",
	//"EISF_Ticket":"0",
	//"Start_time":"10:00",
	//"Event_Desc":"Plants and fungi produce chemicals to defend themselves against attack and to attract animals that will aid their reproduction and dispersal. They can even communicate using chemistry! Explore the chemistry of nature with hands-on activities. And don\u2019t miss the short talks at noon & 2pm. With RBGE and the University of Edinburgh."}

//	<event>
//		<src_code>EISF</src_code>
//		<area_code>EISF</area_code>
//		<event_desc>Natural Chemists</event_desc>
//		<event_code>NATURALC</event_code>
//		<venue_id>38</venue_id>
//		<venue>RGBE</venue>
//		<main_class>ACTIVITY</main_class>
//		<event_info>Plants and fungi produce chemicals to defend themselves against attack and to attract animals that will aid their reproduction and dispersal. They can even communicate using chemistry! Explore the chemistry of nature with hands-on activities. And don’t miss the short talks at noon & 2pm. With RBGE and the University of Edinburgh.</event_info>
//		<start_time_hhmm>1000</start_time_hhmm>
//		<start_time_hhmmss>100000</start_time_hhmmss>
//		<end_time_hhmm>1700</end_time_hhmm>
//		<end_time_hhmmss>170000</end_time_hhmmss>
//		<using_perf_list>
//			<performance>
//				<is_limited>no</is_limited>
//				<date_yyyymmdd>20110409</date_yyyymmdd>
//				<date_desc>09/04/11</date_desc>
//				<time_hhmmss>100000</time_hhmmss>
//				<time_desc>10:00</time_desc>
//			</performance>
//		</using_perf_list>
//		<start_date_yyyymmdd>20110409</start_date_yyyymmdd>
//		<end_date_yyyymmdd>20110409</end_date_yyyymmdd>
//	</event>

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public String getMainClass() {
		return mainClass;
	}
	public void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}
	public String getEventInfo() {
		return eventInfo;
	}
	public void setEventInfo(String eventInfo) {
		this.eventInfo = eventInfo;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Performance[] getPerformances() {
		return performances;
	}
	public void setPerformances(Performance[] performances) {
		this.performances = performances;
	}
	
	public void addPerformance(Performance p) {
		this.performances[this.performances.length + 1] = p; 
	}
	

}
