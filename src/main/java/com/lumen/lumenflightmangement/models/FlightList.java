package com.lumen.lumenflightmangement.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
//@Table(name = "customers")
public class FlightList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	private String flightCode;
	private String origin;
	private String destination;
	private int capacity;
	private LocalDateTime dateAndTimeOfFight;

	@ManyToMany
	@JoinTable(
			name = "flight_passenger_booking",
			joinColumns = @JoinColumn(name = "flightId"),
			inverseJoinColumns = @JoinColumn(name = "customerId"))
	private Set<PassengerList> myPassengerBooking;

	@OneToMany(mappedBy = "flight")
	private Set<BookingList> bookingList;

	public FlightList() {
	}

	public Set<PassengerList> getMyPassengerBooking() {
		return myPassengerBooking;
	}

	public void setMyPassengerBooking(Set<PassengerList> myPassengerBooking) {
		this.myPassengerBooking = myPassengerBooking;
	}

	public Set<BookingList> getBookingList() {
		return bookingList;
	}

	public void setBookingList(Set<BookingList> bookingList) {
		this.bookingList = bookingList;
	}

	public Set<PassengerList> getMyFlightBooking() {
		return myPassengerBooking;
	}

	public void setMyFlightBooking(Set<PassengerList> val) {
		this.myPassengerBooking = val;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}


	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

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

	public LocalDateTime getDateAndTimeOfFight() {
		return dateAndTimeOfFight;
	}

	public void setDateAndTimeOfFight(LocalDateTime dateAndTimeOfFight) {
		this.dateAndTimeOfFight = dateAndTimeOfFight;
	}

//	@Override
//	public String toString() {
//		return "{" +
//				"flightId=" + flightId +
//				", flightCode='" + flightCode + '\'' +
//				", origin='" + origin + '\'' +
//				", destination='" + destination + '\'' +
//				", capacity=" + capacity +
//				", dateAndTimeOfFight=" + dateAndTimeOfFight +
//				", myPassengerBooking=" + myPassengerBooking +
//				", bookingList=" + bookingList +
//				'}';
//	}
}
