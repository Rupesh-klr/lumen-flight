package com.lumen.lumenflightmangement.services;

import com.lumen.lumenflightmangement.viewmodels.FlightListCreateViewModel;
import com.lumen.lumenflightmangement.viewmodels.FlightListGNViewModel;
import com.lumen.lumenflightmangement.viewmodels.FlightListUpdateViewModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

public interface FlightListService {
	FlightListGNViewModel createNewFlightList(FlightListCreateViewModel viewModel);
	FlightListGNViewModel updateFlightListById(int id, FlightListUpdateViewModel viewModel);
	List<FlightListGNViewModel> getAlL();
	List<FlightListGNViewModel> getAlLByOrigin(String location);
	List<FlightListGNViewModel> getAlLByDestination(String location);
	List<FlightListGNViewModel> getAlLByMaxCapacity(int capacity);
	FlightListGNViewModel getById(int id);
	FlightListGNViewModel getByCode(String id);
	FlightListGNViewModel deleteById(int id);
	default boolean pattern(String type, String val){
		switch (type){
			case "mobileNumber":{
				return Pattern.matches("^\\d{10}$",val);
			}
			case "email":{
				String pat= "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				return Pattern.matches(pat,val);
			}
			case "localDateTimeGreaterThan":{
				return LocalDateTime.now().isAfter( LocalDateTime.parse(val)  );
			}
		}
		return false;
	}
}
