package com.tomaszwasik.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tomasz on 12.09.2016.
 */
@Entity
@Table(name = "publisher")
@Data
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<BookEntity> books;

}
