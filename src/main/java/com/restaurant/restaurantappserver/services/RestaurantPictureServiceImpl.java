package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.domain.RestaurantPicture;
import com.restaurant.restaurantappserver.repositories.RestaurantPictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantPictureServiceImpl implements RestaurantPictureService {

    private final RestaurantPictureRepository restaurantPictureRepository;

    @Override
    public RestaurantPicture saveRestaurantPicture(byte[] restaurantPictureByte, Restaurant restaurant) {

        RestaurantPicture restaurantPicture = RestaurantPicture.builder()
                .restaurantPicture(Base64.getEncoder().encodeToString(restaurantPictureByte))
                .restaurant(restaurant).build();
        restaurant.getPictures().add(restaurantPicture);
        return restaurantPictureRepository.save(restaurantPicture);
    }

    @Override
    public List<String> getAllPicturesByRestaurantId(Long restaurantId) {
        return restaurantPictureRepository.findRestaurantPictures(restaurantId);
    }
}
