package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationId;

    @NotBlank(message = "Name is required for reservation")
    private String reservationName;

    @NotBlank(message = "Last name is required for reservation")
    private String reservationLastName;

    @NotBlank(message = "Reservation date is required")
    private String reservationDate;

    @NotBlank(message = "Reservation start field is required")
    private String reservationPeriod;

    @Min(value = 1, message = "Guest count should be greater than zero")
    private int guestCount;

    private String reservationNote;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rtable_id")
    private Rtable rtable;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;
}
