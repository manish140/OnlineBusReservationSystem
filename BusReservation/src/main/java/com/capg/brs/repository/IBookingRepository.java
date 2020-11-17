package com.capg.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.brs.entity.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {

}
