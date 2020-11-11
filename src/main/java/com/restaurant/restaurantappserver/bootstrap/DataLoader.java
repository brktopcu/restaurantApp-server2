package com.restaurant.restaurantappserver.bootstrap;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final RestaurantRepository restaurantRepository;
    private final TableRepository tableRepository;
    private final ReservationRepository reservationRepository;
    private final CommentRepository commentRepository;


    @Override
    public void run(String... args) throws Exception {
        if(restaurantRepository.count() == 0){
            loadData();
        }

    }

    private void loadData(){
        Restaurant r1 = Restaurant.builder()
                .restaurantName("Çalıkuşu")
                .restaurantCity("Samsun")
                .restaurantRating(4.00)
                .totalRating(40)
                .timesRated(1)
                .restaurantAddress("İstiklal Caddesi No:4")
                .phoneNumber("321413542")
                .restaurantCategory("Türk Mutfağı")
                .build();

        Restaurant r2 = Restaurant.builder()
                .restaurantName("Ocakbaşı")
                .restaurantCity("İstanbul")
                .restaurantRating(3.00)
                .totalRating(30)
                .timesRated(1)
                .restaurantAddress("Aydın Sok. No:19")
                .phoneNumber("321422542")
                .restaurantCategory("Türk Mutfağı")
                .build();

        Restaurant r3 = Restaurant.builder()
                .restaurantName("Pizza Nella Italiano")
                .restaurantCity("İstanbul")
                .restaurantRating(5.00)
                .totalRating(50)
                .timesRated(1)
                .restaurantAddress("Abc Sok. No:39")
                .phoneNumber("321122542")
                .restaurantCategory("İtalyan")
                .build();

        Restaurant r4 = Restaurant.builder()
                .restaurantName("Los Altos")
                .restaurantCity("İstanbul")
                .restaurantRating(3.50)
                .totalRating(35)
                .timesRated(1)
                .restaurantAddress("Gümüşsuyu Sok. No:22")
                .phoneNumber("32142444")
                .restaurantCategory("Meksika")
                .build();

        Restaurant r5 = Restaurant.builder()
                .restaurantName("Elvan Pasta")
                .restaurantCity("Ankara")
                .restaurantRating(2.00)
                .totalRating(20)
                .timesRated(1)
                .restaurantAddress("Cihangir Mah. SS Sok. No:2")
                .phoneNumber("321964444")
                .restaurantCategory("Pastacılık")
                .build();

        restaurantRepository.save(r1);
        restaurantRepository.save(r2);
        restaurantRepository.save(r3);
        restaurantRepository.save(r4);
        restaurantRepository.save(r5);



    }
}
