package com.tomaszwasik.controller.rest;


import com.tomaszwasik.data.Author;
import com.tomaszwasik.data.Book;
import com.tomaszwasik.data.User;
import com.tomaszwasik.service.AuthorService;
import com.tomaszwasik.service.BookService;
import com.tomaszwasik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@RestController
@RequestMapping("/api")
public class RestHomeController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;


    @GetMapping
    @RequestMapping("/author")
    public Author reloadAuthor(){
        return authorService.findAuthorByRandomId();
    }

    @GetMapping
    @RequestMapping("/book")
    public Book reloadBook(){
        return bookService.findBookByRandomId();
    }

    @GetMapping
    @RequestMapping("/user")
    public User reloadUser(){
        return userService.findUserByRandomId();
    }
}
