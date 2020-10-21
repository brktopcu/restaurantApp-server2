package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.Rtable;
import com.restaurant.restaurantappserver.services.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/table")
public class TableController {

    private final TableService tableService;

    @GetMapping("/{tableId}")
    public ResponseEntity<Rtable> getTable(@PathVariable Long tableId){
        Rtable rtable = tableService.getById(tableId);
        return new ResponseEntity<>(rtable, HttpStatus.OK);
    }

}
