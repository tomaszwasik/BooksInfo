package com.tomaszwasik.data;


import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private List<BookReview> reviews;
}
