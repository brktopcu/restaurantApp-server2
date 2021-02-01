package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class RestaurantPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantPictureId;

    @Lob
    @NotBlank(message = "Restaurant picture is required")
    private String restaurantPicture;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
