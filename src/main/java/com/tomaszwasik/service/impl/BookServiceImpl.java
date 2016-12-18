package com.tomaszwasik.service.impl;

import com.tomaszwasik.data.Book;
import com.tomaszwasik.entity.BookEntity;
import com.tomaszwasik.repository.BookRepository;
import com.tomaszwasik.service.BookService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@Service(value = "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private Random r;
    Long count = null;

    @Override
    public Book findBookByRandomId() {

        if(count == null){
            count = bookRepository.count();
        }
        long randomId = (long)getRandomNumberInRange(count.intValue());
        BookEntity bookEntity = bookRepository.findOne(randomId);

        if(bookEntity == null){
            findBookByRandomId();
        }

        mapperFactory.classMap(BookEntity.class, Book.class).byDefault();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.map(bookEntity, Book.class);
    }

    private int getRandomNumberInRange(int max) {
        if (1 >= max) {
            throw new IllegalArgumentException("max must be greater than min = 1");
        }
        if(r == null){
            r = new Random();
        }
        return r.nextInt((max - 1) + 1) + 1;
    }

}
