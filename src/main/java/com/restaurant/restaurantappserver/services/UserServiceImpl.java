package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.ApplicationUser;
import com.restaurant.restaurantappserver.exceptions.EmailAlreadyExistsException;
import com.restaurant.restaurantappserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ApplicationUser saveUser(ApplicationUser newUser) {
        try {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            newUser.setUsername(newUser.getUsername());
            return userRepository.save(newUser);
        } catch (Exception e){
            throw new EmailAlreadyExistsException("Username "+newUser.getUsername()+" already exists");
        }

    }
}
