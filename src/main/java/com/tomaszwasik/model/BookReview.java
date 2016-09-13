package com.tomaszwasik.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Tomasz on 12.09.2016.
 */
@Entity
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "review_date")
    private Date reviewDate;

    @Column(name = "review")
    private String review;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BookReview{" +
                "id=" + id +
                ", reviewDate=" + reviewDate +
                ", review='" + review + '\'' +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}
