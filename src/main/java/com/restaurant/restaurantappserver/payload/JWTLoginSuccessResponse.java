package com.restaurant.restaurantappserver.payload;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JWTLoginSuccessResponse {
    private boolean success;
    private String token;
}
