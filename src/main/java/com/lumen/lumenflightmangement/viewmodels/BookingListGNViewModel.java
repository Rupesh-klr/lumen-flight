package com.lumen.lumenflightmangement.viewmodels;


public class BookingListGNViewModel {
	private int seatNumber;
	private FlightListGNViewModel flightListGNViewModel;
	private PassengerListGNViewModel passengerListGNViewModel;

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public FlightListGNViewModel getFlightListGNViewModel() {
		return flightListGNViewModel;
	}

	public void setFlightListGNViewModel(FlightListGNViewModel flightListGNViewModel) {
		this.flightListGNViewModel = flightListGNViewModel;
	}

	public PassengerListGNViewModel getPassengerListGNViewModel() {
		return passengerListGNViewModel;
	}

	public void setPassengerListGNViewModel(PassengerListGNViewModel passengerListGNViewModel) {
		this.passengerListGNViewModel = passengerListGNViewModel;
	}

	@Override
	public String toString() {
		return "{" +
				"seatNumber=" + seatNumber +
				", flightListGNViewModel=" + flightListGNViewModel +
				", passengerListGNViewModel=" + passengerListGNViewModel +
				"} \n";
	}
}
