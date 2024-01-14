package com.lumen.lumenflightmangement.api;

import com.lumen.lumenflightmangement.services.FlightListService;
import com.lumen.lumenflightmangement.viewmodels.FlightListCreateViewModel;
import com.lumen.lumenflightmangement.viewmodels.FlightListGNViewModel;
import com.lumen.lumenflightmangement.viewmodels.FlightListUpdateViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/flight")
public class FlightListApi {
	private  final FlightListService flightListService;

	public FlightListApi(FlightListService flightListService) {
		this.flightListService = flightListService;
	}
	@PostMapping
	public ResponseEntity<FlightListGNViewModel> createNewFlightList(@RequestBody FlightListCreateViewModel viewModel){
		return ResponseEntity.ok( flightListService.createNewFlightList(viewModel) );
	}
	@PutMapping("{id}")
	public ResponseEntity<FlightListGNViewModel> updateFlightListById(@PathVariable int id,@RequestBody FlightListUpdateViewModel viewModel){
		return ResponseEntity.ok( flightListService.updateFlightListById(id, viewModel) );
	}
	@GetMapping("id/{id}")
	public ResponseEntity<FlightListGNViewModel> getById(@PathVariable int id){
		return ResponseEntity.ok( flightListService.getById(id) );
	}
	@GetMapping("code/{code}")
	public ResponseEntity<FlightListGNViewModel> getByCode(@PathVariable String code){
		return ResponseEntity.ok( flightListService.getByCode(code) );
	}
	@GetMapping
	public ResponseEntity<List<FlightListGNViewModel>> getAlL(){
		return ResponseEntity.ok( flightListService.getAlL() );
	}
	@GetMapping("from/{val}")
	public ResponseEntity<List<FlightListGNViewModel>> getAlLByOrigin(@PathVariable String val){
		return ResponseEntity.ok( flightListService.getAlLByOrigin(val) );
	}
	@GetMapping("to/{val}")
	public ResponseEntity<List<FlightListGNViewModel>> getAlLByDestination(@PathVariable String val){
		return ResponseEntity.ok( flightListService.getAlLByDestination(val) );
	}
	@GetMapping("seats/{val}")
	public ResponseEntity<List<FlightListGNViewModel>> getAlLByMaxCapacity(@PathVariable int val){
		return ResponseEntity.ok( flightListService.getAlLByMaxCapacity(val) );
	}
	@DeleteMapping("{id}")
	public ResponseEntity<FlightListGNViewModel> deleteById(@PathVariable int id){
		return ResponseEntity.ok( flightListService.deleteById(id) );
	}
}
