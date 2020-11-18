package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.ApplicationUser;

public interface UserService {
    ApplicationUser saveUser(ApplicationUser newUser);
}
