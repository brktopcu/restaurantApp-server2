package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Rtable;
import com.restaurant.restaurantappserver.exceptions.NotFoundException;
import com.restaurant.restaurantappserver.repositories.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final TableRepository tableRepository;

    @Override
    public Rtable getById(Long id) {
        Optional<Rtable> rtableFound = tableRepository.findById(id);
        if(!rtableFound.isPresent()){
            throw new NotFoundException("Table ID: "+id+" doesn't exist!");
        }
        return rtableFound.get();
    }
}
