package com.lumen.lumenflightmangement.repositories;

import com.lumen.lumenflightmangement.models.BookingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingListRepository extends JpaRepository<BookingList,Integer> {
}
