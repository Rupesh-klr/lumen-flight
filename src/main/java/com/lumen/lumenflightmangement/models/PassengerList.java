package com.lumen.lumenflightmangement.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class PassengerList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private long mobileNumber;

	@ManyToMany(mappedBy = "myPassengerBooking")
	private Set<FlightList> myFlightBooking;

	@OneToMany(mappedBy = "passenger")
	private Set<BookingList> bookingList;

	public Set<BookingList> getBookingList() {
		return bookingList;
	}

	public void setBookingList(Set<BookingList> bookingList) {
		this.bookingList = bookingList;
	}

	public PassengerList() {
	}

	public int getCustomerId() {
		return customerId;
	}

	public Set<FlightList> getMyFlightBooking() {
		return myFlightBooking;
	}

	public void setMyFlightBooking(Set<FlightList> myFlightBooking) {
		this.myFlightBooking = myFlightBooking;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

//	@Override
//	public String toString() {
//		return "{" +
//				"customerId=" + customerId +
//				", firstName='" + firstName + '\'' +
//				", lastName='" + lastName + '\'' +
//				", email='" + email + '\'' +
//				", mobileNumber=" + mobileNumber +
//				", myFlightBooking=" + myFlightBooking +
//				", bookingList=" + bookingList +
//				'}';
//	}
}
