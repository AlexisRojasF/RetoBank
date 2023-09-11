package com.reto.business.rating.client;

import com.reto.business.rating.client.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book")
public interface Bookclient {

    @GetMapping("/book/{id}")
    public Book get(@PathVariable Long id);
}
