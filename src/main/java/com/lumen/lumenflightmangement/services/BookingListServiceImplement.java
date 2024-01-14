package com.lumen.lumenflightmangement.services;

import com.lumen.lumenflightmangement.exceptions.RecordNotFoundException;
import com.lumen.lumenflightmangement.models.BookingList;
import com.lumen.lumenflightmangement.models.FlightList;
import com.lumen.lumenflightmangement.models.PassengerList;
import com.lumen.lumenflightmangement.repositories.BookingListRepository;
import com.lumen.lumenflightmangement.repositories.FlightListRepository;
import com.lumen.lumenflightmangement.repositories.PassengerListRepository;
import com.lumen.lumenflightmangement.viewmodels.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookingListServiceImplement implements BookingListService {
	private final FlightListRepository flightListRepository;
	private final PassengerListRepository passengerListRepository;
	private final BookingListRepository bookingListRepository;
	private final Logger logger;

	public BookingListServiceImplement(FlightListRepository flightListRepository, PassengerListRepository passengerListRepository, BookingListRepository bookingListRepository) {
		this.flightListRepository = flightListRepository;
		this.passengerListRepository = passengerListRepository;
		this.bookingListRepository = bookingListRepository;
		this.logger = LoggerFactory.getLogger(this.getClass().getName());

		System.out.println( (this.bookingListRepository.findAll().stream().map(this::toViewModel).collect(Collectors.toList())).toString() +"   voo\n\n");
	}

	@Override
	public BookingListGNViewModel createBooking(BookingListCreateViewModel viewModel) {
		return toViewModel( this.bookingListRepository.saveAndFlush( toEntity(viewModel) ) );
	}
	public BookingListGNViewModel createBooking(PassengerBookingListCreateViewModel viewModel) {
		BookingListCreateViewModel viewModel1 = new BookingListCreateViewModel();
		PassengerList passengerItem =  this.passengerListRepository.saveAndFlush( toEntity(viewModel)  );
		BeanUtils.copyProperties(viewModel,viewModel1);
		viewModel1.setCustomerId(passengerItem.getCustomerId());
		System.out.println(viewModel1);
		return  createBooking(viewModel1);
	}

	@Override
	public List<BookingListGNViewModel> getAllBookingByFlightId(int id) {
		return filterDataType(1,id);
	}

	@Override
	public List<BookingListGNViewModel> getAllBookingByFlightCode(String id) {
		int flId = getFlightIdByCode(id);
		if(flId == -1)
			throw new RecordNotFoundException( String.format("Flight with given Flight Code '%s' not found!", id ) );
		return getAllBookingByFlightId(flId);
	}
	@Override
	public List<BookingListGNViewModel> getAllBookingByPassengerId(int id) {
		return  filterDataType(2,id);
	}
	//	private helper method for our usage
	private BookingListGNViewModel toViewModel(BookingList entity){
		BookingListGNViewModel viewModel = new BookingListGNViewModel();
		BeanUtils.copyProperties(entity, viewModel);
		viewModel.setFlightListGNViewModel( toViewModel(entity.getFlight()));
		viewModel.setPassengerListGNViewModel( toViewModel(entity.getPassenger()) );
		return viewModel;
	}
	private FlightListGNViewModel toViewModel(FlightList entity){
		FlightListGNViewModel viewModel = new FlightListGNViewModel();
		BeanUtils.copyProperties(entity, viewModel);
		return viewModel;
	}
	private PassengerListGNViewModel toViewModel(PassengerList entity){
		PassengerListGNViewModel viewModel = new PassengerListGNViewModel();
		BeanUtils.copyProperties(entity, viewModel);
		return viewModel;
	}

	protected int getFlightIdByCode(String code) {
		List<FlightList> lists = 		flightListRepository
				.findAll()
				.stream()
				.filter(s-> s.getFlightCode().equals(code)).collect(Collectors.toList());
		return lists.isEmpty() ? -1 :lists.get(0).getFlightId() ;
	}
	private List<BookingListGNViewModel> filterDataType(int option,Object val){
		Stream<BookingList> lists = 		bookingListRepository
				.findAll()
				.stream();
		return  switch (option){
			case 1 -> lists.filter( s -> s.getFlight().getFlightId() == (int)val ).map(this::toViewModel).collect(Collectors.toList());
			case 2 -> lists.filter( s -> s.getPassenger().getCustomerId() == (int) val).map(this::toViewModel).collect(Collectors.toList());
			default->throw new IllegalStateException("Unexpected value: " + option);
		};
	}
	private BookingList toEntity(BookingListCreateViewModel viewModel){
		BookingList entity = new BookingList();
		BeanUtils.copyProperties(viewModel,entity);
		entity.setPassenger(getParentEntityPassenger( viewModel.getCustomerId() ));
		entity.setFlight( getParentEntityFlight( viewModel.getFlightId() ));
		return entity;
	}
	private PassengerList toEntity(PassengerBookingListCreateViewModel viewModel){
		PassengerList entity = new PassengerList();
		BeanUtils.copyProperties(viewModel,entity);
		return entity;
	}
	private PassengerList getParentEntityPassenger(int id){
		return passengerListRepository.findById(id).orElseThrow(()->
				new RecordNotFoundException( String.format("Passenger with given id '%d' not found!", id ) )
		);
	}
	private FlightList getParentEntityFlight(int id){
		return flightListRepository.findById(id).orElseThrow(()->
				new RecordNotFoundException( String.format("Flight with given id '%d' not found!", id ) )
		);
	}
}
