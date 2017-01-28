package com.tomaszwasik.controller;

import com.tomaszwasik.data.Book;
import com.tomaszwasik.entity.BookEntity;
import com.tomaszwasik.entity.BookReviewEntity;
import com.tomaszwasik.entity.UserEntity;
import com.tomaszwasik.service.BookReviewService;
import com.tomaszwasik.service.BookService;
import com.tomaszwasik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@Controller
public class BookReviewController {

    private static final String BOOK_KEY = "book";

    @Autowired
    private BookService bookService;

    @Autowired
    private BookReviewService bookReviewService;

    @Autowired
    private UserService userService;


    @GetMapping("/addBookReview/{id}")
    public String showBookReviewFormPage(HttpServletRequest request, @PathVariable String id, Model model){

        Book book = bookService.findBookById(Long.valueOf(id));
        model.addAttribute(BOOK_KEY, book);

        return "book_review_form";
    }

    @PostMapping("/bookReview/add")
    public String addBookReview(@RequestParam(value = "review") String review, @RequestParam(value = "bookId") String bookId){
        BookEntity bookEntity = bookService.findBookEntityById(Long.valueOf(bookId));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserEntity userEntity = userService.findUserByUsername(username);

        BookReviewEntity bookReviewEntity = new BookReviewEntity();
        bookReviewEntity.setReview(review);
        bookReviewEntity.setReviewDate(Date.valueOf(LocalDate.now()));
        bookReviewEntity.setBook(bookEntity);
        bookReviewEntity.setUser(userEntity);

        bookReviewService.add(bookReviewEntity);

        final UriComponentsBuilder uriComponents = MvcUriComponentsBuilder.fromController(HomeController.class);
        final String path = uriComponents.build().getPath();
        return "redirect:" + path;
    }
}
