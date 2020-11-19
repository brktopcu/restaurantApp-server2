package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Reservation;
import com.restaurant.restaurantappserver.domain.Rtable;
import com.restaurant.restaurantappserver.exceptions.NotFoundException;
import com.restaurant.restaurantappserver.repositories.ReservationRepository;
import com.restaurant.restaurantappserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    @Override
    public Reservation getBydId(Long id) {
        Optional<Reservation> reservationFound = reservationRepository.findById(id);

        if(reservationFound.isEmpty()) throw new NotFoundException("Reservation ID: " + id + " doesn't exist");

        return reservationFound.get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation saveNewReservation(Reservation reservation, Rtable rtable, String username) {
        reservation.setRtable(rtable);
        reservation.setUser(userRepository.findByUsername(username));

        Reservation newReservation = reservation;
        List<Reservation> reservationList = reservationRepository.findAll();

        for(Reservation r : reservationList){
            if((r.getReservationDate().equals(reservation.getReservationDate()))
                    && r.getReservationPeriod().equals(reservation.getReservationPeriod())
                    && r.getRtable().getTableId().equals(reservation.getRtable().getTableId())) {
                newReservation = null;
            }
        }

        if(newReservation != null){
            return reservationRepository.save(newReservation);
        }else return new Reservation();
    }
}
