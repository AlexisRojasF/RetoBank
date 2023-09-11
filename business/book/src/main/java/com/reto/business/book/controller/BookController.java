package com.reto.business.book.controller;

import com.reto.business.book.entity.BookEntity;
import com.reto.business.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> get(@PathVariable Long id) throws Exception {

        return ResponseEntity.ok(service.findById(id));

    }

    @GetMapping()
    public ResponseEntity<List<BookEntity>> getAll() {

        return ResponseEntity.ok(service.findAll());

    }

    @PostMapping
    public ResponseEntity<BookEntity> post(@RequestBody BookEntity input){
        BookEntity save = service.save(input);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<BookEntity> put(@RequestBody BookEntity input){
        BookEntity save = service.edit(input);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        boolean x =service.delete(id);

        if (x) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Elemento Eliminado");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Elemento No Existe");
        }
    }
}
