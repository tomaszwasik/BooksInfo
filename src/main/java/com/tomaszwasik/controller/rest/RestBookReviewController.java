package com.tomaszwasik.controller.rest;

import com.tomaszwasik.controller.HomeController;
import com.tomaszwasik.data.Book;
import com.tomaszwasik.data.BookReview;
import com.tomaszwasik.entity.BookEntity;
import com.tomaszwasik.entity.BookReviewEntity;
import com.tomaszwasik.entity.UserEntity;
import com.tomaszwasik.service.BookReviewService;
import com.tomaszwasik.service.BookService;
import com.tomaszwasik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@RestController
@RequestMapping("/api")
public class RestBookReviewController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookReviewService bookReviewService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/hehe")
    public ResponseEntity<Void> createUser(@RequestBody Book book) {
        System.out.println("Creating Book " + book.getId());

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/bookReview/add")
    public ResponseEntity<Void> addBookReview(@RequestBody BookReview bookReview){

        BookEntity bookEntity = bookService.findBookEntityById(Long.valueOf(bookReview.getId()));

        if(bookEntity == null){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserEntity userEntity = userService.findUserByUsername(username);
        BookReviewEntity bookReviewEntity = new BookReviewEntity();
        bookReviewEntity.setReview(bookReview.getReview());
        bookReviewEntity.setReviewDate(Date.valueOf(LocalDate.now()));
        bookReviewEntity.setBook(bookEntity);
        bookReviewEntity.setUser(userEntity);
        bookReviewService.add(bookReviewEntity);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
