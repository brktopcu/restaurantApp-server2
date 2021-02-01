package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;

    @NotBlank(message = "Restaurant name is required")
    private String restaurantName;

    @NotBlank(message = "Restaurant city is required")
    private String restaurantCity;

    @NotBlank(message = "Restaurant address is required")
    private String restaurantAddress;

    private String restaurantCategory;

    private Double restaurantRating=0.0;

    private Integer totalRating=0;

    private Integer timesRated = 0;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @Lob
    private String thumbnail;

    @Lob
    private String menuPicture;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantPicture> pictures = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Rtable> tableList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_favourite",
            joinColumns = {@JoinColumn(name = "restaurant_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<ApplicationUser> userFavourite = new HashSet<>();


}
