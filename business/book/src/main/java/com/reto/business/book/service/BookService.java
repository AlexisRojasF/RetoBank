package com.reto.business.book.service;

import com.reto.business.book.entity.BookEntity;

import java.util.List;

public interface BookService {


    BookEntity save (BookEntity book);
    boolean delete (Long id);
    BookEntity findById(Long id) throws Exception;
    List<BookEntity> findAll();
    BookEntity edit(BookEntity book);
}
