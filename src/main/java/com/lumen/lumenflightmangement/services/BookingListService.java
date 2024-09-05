package com.lumen.lumenflightmangement.services;

import com.lumen.lumenflightmangement.viewmodels.BookingListCreateViewModel;
import com.lumen.lumenflightmangement.viewmodels.BookingListGNViewModel;
import com.lumen.lumenflightmangement.viewmodels.PassengerBookingListCreateViewModel;

import java.util.List;
import java.util.regex.Pattern;

public interface BookingListService {
	BookingListGNViewModel createBooking(BookingListCreateViewModel viewModel);
	BookingListGNViewModel createBooking(PassengerBookingListCreateViewModel viewModel);
	List<BookingListGNViewModel> getAllBookingByFlightId(int id);
	List<BookingListGNViewModel> getAllBookingByFlightCode(String id);
	List<BookingListGNViewModel> getAllBookingByPassengerId(int id);
	List<BookingListGNViewModel> getAllBooking();
	default boolean pattern(String type, String val){
		switch (type){
			case "mobileNumber":{
				return Pattern.matches("^\\d{10}$",val);
			}
			case "email":{
				return Pattern.matches("^(.+)@(\\S+)$",val);
			}
		}
		return false;
	}

}
