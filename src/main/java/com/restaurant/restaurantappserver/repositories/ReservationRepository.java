package com.restaurant.restaurantappserver.repositories;

import com.restaurant.restaurantappserver.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findReservationsByUser_UserId(Long userId);
}
