package com.lumen.lumenflightmangement.repositories;

import com.lumen.lumenflightmangement.models.PassengerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerListRepository extends JpaRepository<PassengerList,Integer> {
}
