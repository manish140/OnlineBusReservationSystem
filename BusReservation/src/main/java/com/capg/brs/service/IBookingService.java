package com.capg.brs.service;

import java.util.List;
import java.util.Optional;

import com.capg.brs.entity.Booking;

public interface IBookingService {

	
	  public Booking addBooking(Booking booking);
	  public Booking getBookingById(String bookingId);
	  public List<Booking> getAllBookings();
	  public void deleteBooking(String BookingId);
}
