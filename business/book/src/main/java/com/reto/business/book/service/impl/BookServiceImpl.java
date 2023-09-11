package com.reto.business.book.service.impl;

import com.reto.business.book.entity.BookEntity;
import com.reto.business.book.repository.BookRepository;
import com.reto.business.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository repository;

    @Override
    public BookEntity save(BookEntity book) {
        return repository.save(book);
    }

    @Override
    public boolean delete(Long id) {

        Optional<BookEntity> book = repository.findById(id);

        if (book.isPresent()) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public BookEntity findById(Long id) throws Exception {
        Optional<BookEntity> book = repository.findById(id);

        if (book.isPresent()) {
            return book.get();
        }
        throw new Exception("No Exist Book");
    }

    @Override
    public List<BookEntity> findAll() {
        return (List<BookEntity>) repository.findAll();
    }

    @Override
    public BookEntity edit(BookEntity book) {
        return repository.save(book);
    }
}
