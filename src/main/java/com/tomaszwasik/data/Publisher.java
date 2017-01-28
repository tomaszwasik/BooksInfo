package com.tomaszwasik.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * Created by Tomasz on 12.09.2016.
 */
@Data
public class Publisher {

    private Long id;
    private String name;
    private String city;
    private String country;

    /*@JsonIgnore
    private List<Book> books;*/
}
