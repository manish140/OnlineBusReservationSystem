package com.capg.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.entity.Booking;
import com.capg.brs.entity.Bus;
import com.capg.brs.entity.Schedule;


@Repository
public interface IBusRepository extends JpaRepository<Bus, Long> {

	
	@Query("select fare from Bus b where busId=?1")
	Double findFareByBusId(Schedule busId);

	@Query("select seatCapacity from Bus b where busId=?1")
	int findSeatCapacityByBusId(Schedule busId);

	 @Query("UPDATE Bus b SET b.availableSeats = :availableSeats WHERE b.busId = :busId")
	    Booking updateAvailableSeats(Schedule busId,int availableSeats);
	 @Query("SELECT b FROM Bus b WHERE busId = ?1")
	 public Bus getBus(Long busId);
}
