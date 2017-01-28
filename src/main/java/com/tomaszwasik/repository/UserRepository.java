package com.tomaszwasik.repository;

import com.tomaszwasik.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    UserEntity findByUsername(String username);
}
