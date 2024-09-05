package com.lumen.lumenflightmangement.services;

import com.lumen.lumenflightmangement.exceptions.RecordNotFoundException;
import com.lumen.lumenflightmangement.exceptions.RequestNotValidException;
import com.lumen.lumenflightmangement.models.FlightList;
import com.lumen.lumenflightmangement.models.PassengerList;
import com.lumen.lumenflightmangement.repositories.FlightListRepository;
import com.lumen.lumenflightmangement.viewmodels.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FlightListServiceImplement implements FlightListService {
	private  final FlightListRepository flightListRepository;
	private  final Logger logger;

	public FlightListServiceImplement(FlightListRepository flightListRepository) {
		this.flightListRepository = flightListRepository;
		this.logger = LoggerFactory.getLogger(this.getClass().getName());
	}

	@Override
	public FlightListGNViewModel createNewFlightList(FlightListCreateViewModel viewModel) {
		if(pattern("localDateTimeGreaterThan",viewModel.getDateAndTimeOfFight().toString()))
			throw new RequestNotValidException("");
		return  toViewModel( flightListRepository.saveAndFlush(toEntity(viewModel)) );
	}

	@Override
	public FlightListGNViewModel updateFlightListById(int id, FlightListUpdateViewModel viewModel) {
		FlightList entity = getEntityById(id);
		BeanUtils.copyProperties(viewModel,entity);
		return toViewModel( flightListRepository.saveAndFlush(entity) );
	}

	@Override
	public List<FlightListGNViewModel> getAlL() {
		return flightListRepository
				.findAll()
				.stream()
				.map( this::toViewModel )
				.collect(Collectors.toList())
				;
	}
	protected int getFlightIdByCode(String code) {
		List<FlightList> lists = 		flightListRepository
				.findAll()
				.stream()
				.filter(s-> s.getFlightCode().equals(code)).collect(Collectors.toList());
		return lists.isEmpty() ? -1 :lists.get(0).getFlightId() ;
	}
	@Override
	public FlightListGNViewModel getById(int id) {
		return toViewModel( getEntityById(id) );
	}

	@Override
	public FlightListGNViewModel getByCode(String id) {
		int flId = getFlightIdByCode(id);
		if(flId == -1)
			throw new RecordNotFoundException( String.format("Flight with given Flight Code '%s' not found!", id ) );
		return getById(flId);
	}
	@Override
	public List<FlightListGNViewModel> getAlLByOrigin(String location) {
		return filterDataType(2,location);
	}
	@Override
	public List<FlightListGNViewModel> getAlLByDestination(String location) {
		return filterDataType(3,location);
	}

	@Override
	public List<FlightListGNViewModel> getAlLByMaxCapacity(int capacity) {
		return filterDataType(1,capacity);
	}

	@Override
	public FlightListGNViewModel deleteById(int id) {
		FlightList entity = getEntityById(id);
		  flightListRepository.delete(entity);
		return toViewModel(entity);
	}

	//	own helping methods
	private FlightListGNViewModel toViewModel(FlightList entity){
		FlightListGNViewModel viewModel = new FlightListGNViewModel();
		BeanUtils.copyProperties(entity, viewModel);
		return viewModel;
	}
	private List<FlightListGNViewModel> filterDataType(int option,Object val){
		Stream<FlightList> lists = 		flightListRepository
				.findAll()
				.stream();
		return  switch (option){
			case 1 -> lists.filter( s -> s.getCapacity() > (int)val ).map(this::toViewModel).collect(Collectors.toList());
			case 2 -> lists.filter( s -> s.getOrigin().equals( (String)val ) ).map(this::toViewModel).collect(Collectors.toList());
			case 3 -> lists.filter( s -> s.getDestination().equals( (String)val ) ).map(this::toViewModel).collect(Collectors.toList());
			default->throw new IllegalStateException("Unexpected value: " + option);
		};
	}
	private FlightList toEntity(FlightListCreateViewModel viewModel){
		System.out.println(viewModel);
		FlightList entity = new FlightList();
		BeanUtils.copyProperties(viewModel,entity);
		return entity;
	}
	protected FlightList getEntityById(int id){
		return flightListRepository.findById(id).orElseThrow(()->
				new RecordNotFoundException( String.format("Flight with given id '%d' not found!", id ) )
		);
	}
}
