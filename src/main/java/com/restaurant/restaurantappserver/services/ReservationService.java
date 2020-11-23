package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Reservation;
import com.restaurant.restaurantappserver.domain.Rtable;

import java.util.List;

public interface ReservationService {

    Reservation getBydId(Long id);

    List<Reservation> getAllReservations();

    List<Reservation> getReservationsByUserId(Long userId);

    Reservation saveNewReservation(Reservation reservation, Rtable rtable, String username);

    void deleteById(Long id);
}
