package com.tomaszwasik.repository;

import com.tomaszwasik.entity.BookReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
public interface BookReviewRepository extends JpaRepository<BookReviewEntity, Long>{
}
