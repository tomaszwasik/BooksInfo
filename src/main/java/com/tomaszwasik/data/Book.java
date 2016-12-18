package com.tomaszwasik.data;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * Created by Tomasz on 30.08.2016.
 */
@Data
public class Book {

    private Long id;
    private String title;
    private Date publicationDate;
    private String description;
    private double averagePrice;
    private Author author;
    private Publisher publisher;
    private List<BookReview> reviews;
}
