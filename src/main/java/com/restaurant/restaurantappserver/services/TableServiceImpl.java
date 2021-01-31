package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.domain.Rtable;
import com.restaurant.restaurantappserver.exceptions.NotFoundException;
import com.restaurant.restaurantappserver.repositories.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final TableRepository tableRepository;

    @Override
    public Rtable getById(Long id) {
        Optional<Rtable> rtableFound = tableRepository.findById(id);
        if(rtableFound.isEmpty())throw new NotFoundException("Table ID: "+id+" doesn't exist!");

        return rtableFound.get();
    }

    @Override
    public List<Rtable> getAllTablesForRestaurant(Long id) {
        List<Rtable> rtableList = tableRepository.findTables(id);
        return rtableList;
    }

    @Override
    public Rtable saveNewTable(Rtable rtable, Restaurant restaurant) {
        rtable.setRestaurant(restaurant);

        return tableRepository.save(rtable);
    }

    @Override
    public String saveMultipleTables(Integer numberOfTables, Integer tableCapacity, Restaurant restaurant) {
        for(int i=1; i<=numberOfTables;i++){
            tableRepository.save(new Rtable("M"+i,tableCapacity,restaurant));
        }

        return "Tables created";
    }
}
