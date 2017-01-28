package com.tomaszwasik.service.impl;

import com.tomaszwasik.data.Author;
import com.tomaszwasik.entity.AuthorEntity;
import com.tomaszwasik.repository.AuthorRepository;
import com.tomaszwasik.repository.BookRepository;
import com.tomaszwasik.service.AuthorService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private Random r;
    Long count = null;

    @Override
    public Author findAuthorByRandomId() {

        if(count == null){
            count = authorRepository.count();
        }

        long randomId = (long)getRandomNumberInRange(count.intValue());
        AuthorEntity authorEntity = authorRepository.findOne(randomId);

        if(authorEntity == null){
            findAuthorByRandomId();
        }

        mapperFactory.classMap(AuthorEntity.class, Author.class).byDefault();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        Author author = mapperFacade.map(authorEntity, Author.class);
        Long booksQuantity = bookRepository.countByAuthorId(authorEntity.getId());
        author.setBooksQuantity(booksQuantity);
        return author;
    }

    private int getRandomNumberInRange(int max) {
        if (1 >= max) {
            return 1;
        }
        if(r == null){
            r = new Random();
        }
        return r.nextInt((max - 1) + 1) + 1;
    }
}
