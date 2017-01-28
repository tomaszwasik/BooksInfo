package com.tomaszwasik.data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String description;
    private String phoneNo;
    private Long reviewsQuantity;

    /*@JsonIgnore
    private List<BookReview> reviews;*/
}
