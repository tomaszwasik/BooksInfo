package com.tomaszwasik.data;

import lombok.Data;

import java.sql.Date;

/**
 * Created by Tomasz on 12.09.2016.
 */
@Data
public class BookReview {

    private Long id;
    private Date reviewDate;
    private String review;
    private Book book;
    private User user;
}
