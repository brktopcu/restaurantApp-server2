package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.ApplicationUser;
import com.restaurant.restaurantappserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username);
        if(user==null) throw new UsernameNotFoundException("User not found");
        return user;
    }

    @Transactional
    public ApplicationUser loadUserById(Long id){
        ApplicationUser user = userRepository.getByUserId(id);
        if(user==null) throw new UsernameNotFoundException("User not found");
        return user;
    }
}
