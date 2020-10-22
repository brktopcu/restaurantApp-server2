package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;

    @NotBlank(message = "Restaurant name is required")
    private String restaurantName;

    @NotBlank(message = "Restaurant address is required")
    private String restaurantAddress;

    private String restaurantCategory; //TODO create an enum for restaurant category

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Rtable> tableList = new ArrayList<>();



    //TODO add pictures
    //TODO add thumbnail
    //TODO add menu pic

}
