package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Reservation;
import com.restaurant.restaurantappserver.domain.Rtable;
import com.restaurant.restaurantappserver.exceptions.NotFoundException;
import com.restaurant.restaurantappserver.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation getBydId(Long id) {
        Optional<Reservation> reservationFound = reservationRepository.findById(id);

        if(reservationFound.isEmpty()){
            throw new NotFoundException("Reservation ID: " + id + " doesn't exist");
        }

        return reservationFound.get();
    }

    @Override
    public Reservation saveNewReservation(Reservation reservation, Rtable rtable) {

        reservation.setRtable(rtable);

        Reservation newReservation = reservationRepository.save(reservation);

        return newReservation;
    }
}
