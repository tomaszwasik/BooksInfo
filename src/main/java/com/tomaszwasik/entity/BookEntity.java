package com.tomaszwasik.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Tomasz on 30.08.2016.
 */
@Entity
@Table(name = "book")
@Data
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publication_date", columnDefinition = "Date")
    private Date publicationDate;

    @Column(name = "description", columnDefinition = "VARCHAR(1024) NULL")
    private String description;

    @Column (name = "average_price")
    private double averagePrice;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookReviewEntity> reviews;

}
