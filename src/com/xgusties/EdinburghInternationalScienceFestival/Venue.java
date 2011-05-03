package com.xgusties.EdinburghInternationalScienceFestival;

public class Venue {

	public Venue(Integer id, String name, Integer capacity) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}
	
	private Integer id;
	private String name;
	private Integer capacity;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
}
