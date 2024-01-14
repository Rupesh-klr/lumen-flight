package com.lumen.lumenflightmangement.api;

import com.lumen.lumenflightmangement.models.PassengerList;
import com.lumen.lumenflightmangement.repositories.PassengerListRepository;
import com.lumen.lumenflightmangement.services.PassengerListService;
import com.lumen.lumenflightmangement.viewmodels.PassengerListCreateViewModel;
import com.lumen.lumenflightmangement.viewmodels.PassengerListGNViewModel;
import com.lumen.lumenflightmangement.viewmodels.PassengerListUpdateViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/passenger")
public class PassengerListApi {
	private final PassengerListService passengerListService;

	public PassengerListApi(PassengerListService passengerListService) {
		this.passengerListService = passengerListService;
	}
	@PostMapping
	public ResponseEntity<PassengerListGNViewModel> createPassenger(@RequestBody PassengerListCreateViewModel viewModel){
		return ResponseEntity.ok( passengerListService.createPassenger(viewModel) );
	}
	@PutMapping("{id}")
	public ResponseEntity<PassengerListGNViewModel> updatePassenger(@PathVariable int id, @RequestBody PassengerListUpdateViewModel viewModel){
		return ResponseEntity.ok( passengerListService.updatePassenger(id,viewModel) );
	}
	@GetMapping
	public ResponseEntity<List<PassengerListGNViewModel>>  getAll(){
		return ResponseEntity.ok( passengerListService.getAll() );
	}
	@GetMapping("{id}")
	public ResponseEntity<PassengerListGNViewModel> getById(@PathVariable int id){
		return ResponseEntity.ok( passengerListService.getById(id) );
	}
	@DeleteMapping("{id}")
	public ResponseEntity<PassengerListGNViewModel> deleteById(@PathVariable int id){
		return ResponseEntity.ok( passengerListService.deleteById(id) );
	}
}
