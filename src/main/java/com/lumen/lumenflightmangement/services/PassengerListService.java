package com.lumen.lumenflightmangement.services;

import com.lumen.lumenflightmangement.models.PassengerList;
import com.lumen.lumenflightmangement.viewmodels.PassengerListCreateViewModel;
import com.lumen.lumenflightmangement.viewmodels.PassengerListGNViewModel;
import com.lumen.lumenflightmangement.viewmodels.PassengerListUpdateViewModel;

import java.util.List;
import java.util.regex.Pattern;

public interface PassengerListService {
	PassengerListGNViewModel createPassenger(PassengerListCreateViewModel viewModel);
	PassengerListGNViewModel updatePassenger(int id,PassengerListUpdateViewModel viewModel);
	List<PassengerListGNViewModel> getAll();
	PassengerListGNViewModel getById(int id);
	PassengerListGNViewModel deleteById(int id);
	default boolean pattern(String type, String val){
		switch (type){
			case "mobileNumber":{
				return Pattern.matches("^\\d{10}$",val);
			}
			case "email":{
				String pat= "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				return Pattern.matches(pat,val);
			}
		}
		return false;
	}
}
