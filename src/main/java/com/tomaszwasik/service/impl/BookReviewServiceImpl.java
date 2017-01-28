package com.tomaszwasik.service.impl;

import com.tomaszwasik.entity.BookReviewEntity;
import com.tomaszwasik.repository.BookRepository;
import com.tomaszwasik.repository.BookReviewRepository;
import com.tomaszwasik.service.BookReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@Service
public class BookReviewServiceImpl implements BookReviewService{

    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Override
    public BookReviewEntity add(BookReviewEntity bookReviewEntity) {
        return bookReviewRepository.save(bookReviewEntity);
    }
}
