package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Reservation;
import com.restaurant.restaurantappserver.domain.Rtable;

import java.util.List;

public interface ReservationService {

    Reservation getBydId(Long id);

    List<Reservation> getAllReservations();

    Reservation saveNewReservation(Reservation reservation, Rtable rtable);
}
