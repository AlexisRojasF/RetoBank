package com.reto.business.rating.service.impl;

import com.reto.business.rating.client.Bookclient;
import com.reto.business.rating.client.model.Book;
import com.reto.business.rating.dto.RatingAndBook;
import com.reto.business.rating.entity.RatingEntity;
import com.reto.business.rating.repository.RatingRepository;
import com.reto.business.rating.service.RatingServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceFeignImpl implements RatingServiceFeign


{

    @Autowired
    private RatingRepository repository;

    @Autowired
    private Bookclient bookClient;


    @Override
    public RatingAndBook findById(Long id) throws Exception {
        Optional<RatingEntity> rating = repository.findById(id);

        if (rating.isPresent()){
            Book BookClient = bookClient.get(rating.get().getBookId());
            RatingAndBook RatingAndBook;
            RatingAndBook = new RatingAndBook(rating.get().getId(),BookClient,rating.get().getStars());
            return RatingAndBook;
        } else {
            throw new Exception("No Exist Rating");
        }



    }
}
