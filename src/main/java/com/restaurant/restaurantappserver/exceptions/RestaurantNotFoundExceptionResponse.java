package com.restaurant.restaurantappserver.exceptions;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantNotFoundExceptionResponse {

    @JsonProperty("Not Found")
    private String notFound;
}
