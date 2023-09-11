package com.reto.business.rating.dto;

import com.reto.business.rating.client.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RatingAndBook {

    private Long id;
    private Book book;
    private Integer stars;
}
