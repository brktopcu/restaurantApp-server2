package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.exceptions.NotFoundException;
import com.restaurant.restaurantappserver.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant getById(Long restaurantId) {

        Optional<Restaurant> restaurantFound = restaurantRepository.findById(restaurantId);
        if(restaurantFound.isPresent()){
            return restaurantFound.get();
        }else{
            throw new NotFoundException("Restaurant ID: "+restaurantId+" doesn't exist!");
        }
    }

    @Override
    public Restaurant saveNewRestaurant(Restaurant restaurant) {

        Restaurant savedNewRestaurant = restaurantRepository.save(restaurant);

        return savedNewRestaurant;
    }


}
