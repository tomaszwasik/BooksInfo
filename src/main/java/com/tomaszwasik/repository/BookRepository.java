package com.tomaszwasik.repository;

import com.tomaszwasik.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
public interface BookRepository extends JpaRepository<BookEntity, Long>{
}
