package com.xgusties.EdinburghInternationalScienceFestival;

public class SubVenue extends Venue {
	
	public SubVenue(Integer id, String name, Integer capacity, String subVenueName) {
		super(id, name, capacity);
		this.setSubVenueName(subVenueName);
	}

	private String subVenueName;
	
	
	public String getSubVenueName() {
		return subVenueName;
	}

	public void setSubVenueName(String subVenueName) {
		this.subVenueName = subVenueName;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.subVenueName + ", " + super.getName();
	}

	// TODO - check if we need this for $subVenue->getVenue()->getName()
	// maybe this would work instead: ((Venue) $subVenue)->getVenue()
	public Venue getVenue() {
		return new Venue(this.getId(), this.getName(), this.getCapacity());
	}

}
