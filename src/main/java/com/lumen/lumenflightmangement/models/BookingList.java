package com.lumen.lumenflightmangement.models;

import jakarta.persistence.*;

@Entity
//@Table("")
public class BookingList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	private int flightId;
//	private int customerId;
	private int seatNumber;

	@ManyToOne
	@JoinColumn(name = "flightId")
	private FlightList flight;
	@ManyToOne
	@JoinColumn(name = "customerId")
	private PassengerList passenger ;

	public BookingList() {	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public FlightList getFlight() {
		return flight;
	}

	public void setFlight(FlightList flight) {
		this.flight = flight;
	}

	public PassengerList getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerList passenger) {
		this.passenger = passenger;
	}

}
