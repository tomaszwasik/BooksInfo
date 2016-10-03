package com.tomaszwasik.data;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * Created by Tomasz on 12.09.2016.
 */
@Data
public class Author {

    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private String description;
    private List<Book> books;

}



