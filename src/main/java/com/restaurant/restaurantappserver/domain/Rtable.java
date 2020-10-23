package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rtable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tableId;

    @NotBlank(message = "Table name is required")
    private String tableName;

    @NotNull(message = "Table capacity is required")
    private int tableCapacity;

    private String tableDescription;

    @OneToMany(mappedBy = "rtable", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;



}
