package com.restaurant.restaurantappserver.exceptions;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotFoundExceptionResponse {

    @JsonProperty("Not Found")
    private String notFound;
}
