package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationId;

    @NotBlank(message = "Reservation start field is required")
    private String reservationStart;

    private String reservationEnd;

    @NotNull(message = "Guest count is required")
    private int guestCount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rtable_id")
    private Rtable rtable;

    //TODO OneToMany w user
}
