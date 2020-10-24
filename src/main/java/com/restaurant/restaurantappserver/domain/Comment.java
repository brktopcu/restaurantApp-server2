package com.restaurant.restaurantappserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @NotBlank
    private String commentText;

    @Range(min = 0, max = 5)
    private int commentScore;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    ApplicationUser user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;
}
