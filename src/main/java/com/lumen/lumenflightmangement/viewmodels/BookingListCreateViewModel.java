package com.lumen.lumenflightmangement.viewmodels;

public class BookingListCreateViewModel {
	private int flightId;
	private int customerId;
	private int seatNumber;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "--->{" +
				"flightId=" + flightId +
				", customerId=" + customerId +
				", seatNumber=" + seatNumber +
				'}';
	}
}
