package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    private String tableDescription;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
