package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.domain.Rtable;
import com.restaurant.restaurantappserver.services.HeaderService;
import com.restaurant.restaurantappserver.services.RestaurantService;
import com.restaurant.restaurantappserver.services.TableService;
import com.restaurant.restaurantappserver.services.ValidationErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/table")
public class TableController {

    private final TableService tableService;
    private final RestaurantService restaurantService;
    private final ValidationErrorService validationErrorService;
    private final HeaderService headerService;

    @GetMapping("/{tableId}")
    public ResponseEntity<Rtable> getTable(@PathVariable Long tableId){
        Rtable rtable = tableService.getById(tableId);
        return new ResponseEntity<>(rtable, HttpStatus.OK);
    }

    @GetMapping("/all/{restaurantId}")
    public ResponseEntity<List<Rtable>> getAllTablesForRestaurant(@PathVariable Long restaurantId){
        List<Rtable> rtableList = tableService.getAllTablesForRestaurant(restaurantId);

        return new ResponseEntity<>(rtableList, headerService.getHeaders(), HttpStatus.OK);
    }

    @PostMapping("/{restaurantId}")
    public ResponseEntity<?> saveTable(@Valid @RequestBody Rtable rtable,
                                       BindingResult bindingResult,
                                       @PathVariable Long restaurantId){

        ResponseEntity<?> errorMap = validationErrorService.validationMap(bindingResult);
        if(errorMap!=null) return errorMap;

        Restaurant restaurant = restaurantService.getById(restaurantId);
        Rtable savedTable = tableService.saveNewTable(rtable,restaurant);

        return new ResponseEntity<>(savedTable, HttpStatus.CREATED);
    }

}
