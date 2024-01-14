package com.lumen.lumenflightmangement.viewmodels;

import java.time.LocalDateTime;

public class FlightListUpdateViewModel {
	private String origin;
	private String destination;
	private int capacity;
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
