package com.tomaszwasik.controller;

import com.tomaszwasik.data.Author;
import com.tomaszwasik.data.Book;
import com.tomaszwasik.data.User;
import com.tomaszwasik.service.AuthorService;
import com.tomaszwasik.service.BookService;
import com.tomaszwasik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    private static final String AUTHOR_KEY = "author";
    private static final String BOOK_KEY = "book";
    private static final String USER_KEY = "user";


    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String home(Model model) {

        Author author = authorService.findAuthorByRandomId();
        Book book = bookService.findBookByRandomId();
        User user = userService.findUserByRandomId();

        model.addAttribute(AUTHOR_KEY, author);
        model.addAttribute(BOOK_KEY, book);
        model.addAttribute(USER_KEY, user);

        return "index";
    }

    @GetMapping ("/reloadBook")
    public String reloadBook(Model model){
        return home(model);

    }

    @GetMapping ("/reloadAuthor")
    public String reloadAuthor(Model model){
        return home(model);

    }

    @GetMapping ("/reloadUser")
    public String reloadUser(Model model){
        return home(model);

    }


}
