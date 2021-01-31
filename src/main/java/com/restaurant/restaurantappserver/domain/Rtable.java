package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
@Builder
public class Rtable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tableId;

    @NotBlank(message = "Table name is required")
    private String tableName;

    @NotNull(message = "Table capacity is required")
    private Integer tableCapacity;

    private String tableDescription;

    @OneToMany(mappedBy = "rtable", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Rtable(String tableName, Integer tableCapacity, Restaurant restaurant ){
        this.tableName=tableName;
        this.tableCapacity=tableCapacity;
        this.restaurant=restaurant;
    }



}
