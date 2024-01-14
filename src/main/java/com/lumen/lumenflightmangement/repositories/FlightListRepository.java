package com.lumen.lumenflightmangement.repositories;

import com.lumen.lumenflightmangement.models.FlightList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightListRepository extends JpaRepository<FlightList,Integer> {
}
