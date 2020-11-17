package com.capg.brs.service;

import java.util.List;
import java.util.Optional;

import com.capg.brs.entity.Booking;

public interface IBookingService {

	
	Booking addBooking(Booking booking);
	 Optional<Booking> getBookingById(String bookingId);
		List<Booking> getAllBookings();
		void deleteBooking(String BookingId);
}
