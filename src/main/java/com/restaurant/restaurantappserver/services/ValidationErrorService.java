package com.restaurant.restaurantappserver.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface ValidationErrorService {

    ResponseEntity<?> validationMap(BindingResult result);

}
