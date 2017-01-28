package com.tomaszwasik.service;

import com.tomaszwasik.data.Book;
import com.tomaszwasik.entity.BookEntity;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
public interface BookService {

    Book findBookByRandomId();

    BookEntity findBookEntityById(long id);

    Book findBookById(long id);

}
