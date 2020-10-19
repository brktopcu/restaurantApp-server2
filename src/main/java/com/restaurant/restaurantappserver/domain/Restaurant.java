package com.restaurant.restaurantappserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;

    private String restaurantName;
    private String restaurantAddress;
    private String restaurantCategory; //TODO create an enum for restaurant category
    //TODO add pictures
    //TODO add thumbnail
    private String phoneNumber;
    //TODO add menu pic

}
