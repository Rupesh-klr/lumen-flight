package com.lumen.lumenflightmangement.services;

import com.lumen.lumenflightmangement.viewmodels.FlightListCreateViewModel;
import com.lumen.lumenflightmangement.viewmodels.FlightListGNViewModel;
import com.lumen.lumenflightmangement.viewmodels.FlightListUpdateViewModel;

import java.util.List;

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
}
