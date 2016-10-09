package com.tomaszwasik.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Tomasz on 12.09.2016.
 */
@Entity
@Table(name = "book_review")
@Data
public class BookReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "review_date", columnDefinition = "Date")
    private Date reviewDate;

    @Column(name = "review")
    private String review;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
