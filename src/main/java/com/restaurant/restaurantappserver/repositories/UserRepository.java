package com.restaurant.restaurantappserver.repositories;

import com.restaurant.restaurantappserver.domain.ApplicationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser, Long> {
}
