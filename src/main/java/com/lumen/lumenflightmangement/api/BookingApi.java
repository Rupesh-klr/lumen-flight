package com.lumen.lumenflightmangement.api;

import com.lumen.lumenflightmangement.services.BookingListService;
import com.lumen.lumenflightmangement.viewmodels.BookingListCreateViewModel;
import com.lumen.lumenflightmangement.viewmodels.BookingListGNViewModel;
import com.lumen.lumenflightmangement.viewmodels.PassengerBookingListCreateViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/booking")
public class BookingApi {
	private  final  BookingListService bookingListService;
	public BookingApi(BookingListService bookingListService) {
		this.bookingListService = bookingListService;
	}
	@PostMapping
	public ResponseEntity<BookingListGNViewModel> createBooking(@RequestBody BookingListCreateViewModel viewModel){
		System.out.println("ResponseEntity<BookingListGNViewModel> createBooking "+ viewModel);
		return ResponseEntity.ok(bookingListService.createBooking(viewModel) );
	}
	@PostMapping("newuser")
	public ResponseEntity<BookingListGNViewModel> createBooking(@RequestBody PassengerBookingListCreateViewModel viewModel){
		System.out.println("createBooking "+ viewModel);
		return ResponseEntity.ok(bookingListService.createBooking(viewModel) );
	}
	@GetMapping
	public ResponseEntity<List <BookingListGNViewModel> >  getAllBooking(){
		return ResponseEntity.ok(bookingListService.getAllBooking() );
	}
	@GetMapping("id/{id}")
	public ResponseEntity<List <BookingListGNViewModel> >  getAllBookingByFlightId(@PathVariable int id){
		return ResponseEntity.ok(bookingListService.getAllBookingByFlightId(id) );
	}
	@GetMapping("code/{id}")
	public ResponseEntity<List <BookingListGNViewModel> >  getAllBookingByFlightCode(@PathVariable String id){
		return ResponseEntity.ok(bookingListService.getAllBookingByFlightCode(id) );
	}
	@GetMapping("mybooking/{id}")
	public ResponseEntity<List <BookingListGNViewModel> >  getAllBookingByPassengerId(@PathVariable int id){
		return ResponseEntity.ok(bookingListService.getAllBookingByPassengerId(id) );
	}
}
