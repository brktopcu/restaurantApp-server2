package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Reservation;
import com.restaurant.restaurantappserver.domain.Rtable;

public interface ReservationService {

    Reservation getBydId(Long id);

    Reservation saveNewReservation(Reservation reservation, Rtable rtable);
}
