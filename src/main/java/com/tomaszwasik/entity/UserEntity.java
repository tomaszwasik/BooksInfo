package com.tomaszwasik.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tomasz Wąsik.
 */
@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookReviewEntity> reviews;

}
