package com.lumen.lumenflightmangement.services;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.lumen.lumenflightmangement.exceptions.InvalidEmailIdFormatException;
import com.lumen.lumenflightmangement.exceptions.InvalidModileNumberFormatException;
import com.lumen.lumenflightmangement.exceptions.RecordNotFoundException;
import com.lumen.lumenflightmangement.models.PassengerList;
import com.lumen.lumenflightmangement.repositories.PassengerListRepository;
import com.lumen.lumenflightmangement.viewmodels.PassengerListCreateViewModel;
import com.lumen.lumenflightmangement.viewmodels.PassengerListGNViewModel;
import com.lumen.lumenflightmangement.viewmodels.PassengerListUpdateViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerListServiceImplement implements PassengerListService {
	private final PassengerListRepository passengerListRepository;
	private final Logger logger;

	public PassengerListServiceImplement(PassengerListRepository passengerListRepository) {
		this.passengerListRepository = passengerListRepository;
		this.logger = LoggerFactory.getLogger(this.getClass().getName());
	}

	@Override
	public PassengerListGNViewModel createPassenger(PassengerListCreateViewModel viewModel) {
		if(!pattern("email", viewModel.getEmail()) || !pattern("mobileNumber", String.valueOf( viewModel.getMobileNumber()) )){
			if ( pattern("email", viewModel.getEmail()) )
				throw new InvalidModileNumberFormatException("Given number is not in number Format.");

			throw new InvalidEmailIdFormatException("Given email-id is not in correct format.");
		}
		return toViewModel( passengerListRepository.saveAndFlush(
									toEntity(viewModel)
				));
	}

	@Override
	public PassengerListGNViewModel updatePassenger(int id,PassengerListUpdateViewModel viewModel) {
		PassengerList entity = getEntityById(id);
		BeanUtils.copyProperties(viewModel,entity);
		return toViewModel( passengerListRepository.saveAndFlush(entity) );
	}

	@Override
	public List<PassengerListGNViewModel> getAll() {
		return passengerListRepository
				.findAll()
				.stream()
				.map(this::toViewModel)
				.collect(Collectors.toList())
				;
	}

	@Override
	public PassengerListGNViewModel getById(int id) {
		return toViewModel( getEntityById(id) );
	}

	@Override
	public PassengerListGNViewModel deleteById(int id) {
		PassengerList entity = getEntityById(id);
		passengerListRepository.delete(entity);
		return  toViewModel( entity );
	}

//	own helping methods
	private PassengerListGNViewModel toViewModel(PassengerList entity){
		PassengerListGNViewModel viewModel = new PassengerListGNViewModel();
		BeanUtils.copyProperties(entity, viewModel);
		return viewModel;
	}
	private PassengerList toEntity(PassengerListCreateViewModel viewModel){
		PassengerList entity = new PassengerList();
		BeanUtils.copyProperties(viewModel,entity);
		entity.setCustomerId(-1);
		System.out.println(entity.getCustomerId());
		return entity;
	}
	protected PassengerList getEntityById(int id){
		return passengerListRepository.findById(id).orElseThrow(()->
			new RecordNotFoundException( String.format("Passenger with given id '%d' not found!", id ) )
		);
	}
}
