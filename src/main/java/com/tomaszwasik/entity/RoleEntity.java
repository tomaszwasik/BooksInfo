package com.tomaszwasik.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@Entity
@Table(name = "role")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "role_name", unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;
}
