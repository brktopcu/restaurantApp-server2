package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
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

    @Min(value = 1, message = "Guest count should be greater than zero")
    private int guestCount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rtable_id")
    private Rtable rtable;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;
}
