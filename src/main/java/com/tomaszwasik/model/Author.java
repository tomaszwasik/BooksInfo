package com.tomaszwasik.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Tomasz on 12.09.2016.
 */
@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

}



