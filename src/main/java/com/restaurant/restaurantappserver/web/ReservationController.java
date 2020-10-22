package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.Reservation;
import com.restaurant.restaurantappserver.domain.Rtable;
import com.restaurant.restaurantappserver.services.ReservationService;
import com.restaurant.restaurantappserver.services.TableService;
import com.restaurant.restaurantappserver.services.ValidationErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final ValidationErrorService validationErrorService;
    private final TableService tableService;

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id){

        Reservation reservationFound = reservationService.getBydId(id);

        return new ResponseEntity<>(reservationFound, HttpStatus.OK);
    }

    @PostMapping("/{tableId}")
    public ResponseEntity<?> saveReservation(@Valid @RequestBody Reservation reservation,
                                             BindingResult bindingResult,
                                             @PathVariable Long tableId){

        ResponseEntity<?> errorMap = validationErrorService.validationMap(bindingResult);

        if(errorMap!=null){
            return errorMap;
        }

        Rtable reservationTable = tableService.getById(tableId);
        Reservation reservationToSave = reservationService.saveNewReservation(reservation, reservationTable);

        return new ResponseEntity<>(reservationToSave, HttpStatus.CREATED);

    }
}
