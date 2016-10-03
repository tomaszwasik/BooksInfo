package com.tomaszwasik.repository;

import com.tomaszwasik.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>{
}
