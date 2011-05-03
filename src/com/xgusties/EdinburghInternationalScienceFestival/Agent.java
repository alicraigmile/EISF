package com.xgusties.EdinburghInternationalScienceFestival;

public abstract class Agent {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Agent(String name) {
		super();
		this.name = name;
	}
	
	

}
