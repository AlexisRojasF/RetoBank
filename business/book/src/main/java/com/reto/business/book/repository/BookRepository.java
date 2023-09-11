package com.reto.business.book.repository;

import com.reto.business.book.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity,Long> {
}
