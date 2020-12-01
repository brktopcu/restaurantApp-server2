package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.exceptions.NotFoundException;
import com.restaurant.restaurantappserver.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant getById(Long restaurantId) {

        Optional<Restaurant> restaurantFound = restaurantRepository.findById(restaurantId);
        if(restaurantFound.isEmpty()) throw new NotFoundException("Restaurant ID: "+restaurantId+" doesn't exist!");

        return restaurantFound.get();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();

        return restaurantList;
    }



    @Override
    public Restaurant saveNewRestaurant(Restaurant restaurant) {

        Restaurant savedNewRestaurant = restaurantRepository.save(restaurant);

        return savedNewRestaurant;
    }

    @Override
    public List<Restaurant> searchByRestaurantName(String search) {
        List<Restaurant> foundList = restaurantRepository.findByRestaurantNameContaining(search);
        if(foundList.isEmpty()) throw new NotFoundException("Search results are empty!");

        return foundList;
    }

    @Override
    public List<String> findDistinctRestaurantCities() {
        List<String> foundCities = restaurantRepository.findDistinctRestaurants();
        if(foundCities.isEmpty()) throw new NotFoundException("Search results are empty!");

        return foundCities;
    }

    @Override
    public List<String> findDistinctRestaurantCategories() {
        List<String> foundCategories = restaurantRepository.findDistinctCategories();
        if(foundCategories.isEmpty()) throw new NotFoundException("Search results are empty!");

        return foundCategories;
    }

    @Override
    public Restaurant saveRestaurantThumbnail(Long restaurantId, byte[] thumbnail) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        Restaurant restaurant = restaurantOptional.get();
        restaurant.setThumbnail(Base64.getEncoder().encodeToString(thumbnail));
        return restaurantRepository.save(restaurant);
    }
}
