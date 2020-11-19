package com.capg.brs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.entity.Booking;
import com.capg.brs.entity.Schedule;
import com.capg.brs.entity.User;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {


	@Query("SELECT b FROM Booking b WHERE bookingId = ?1")
	public Booking getBooking(Long bookingId);

	 @Query("UPDATE Booking b SET b.ticketCost = :ticketCost WHERE b.userId = :userId")
	    Booking update(User userId,double ticketCost);
}
