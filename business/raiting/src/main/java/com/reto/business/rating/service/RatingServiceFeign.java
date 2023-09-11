package com.reto.business.rating.service;

import com.reto.business.rating.dto.RatingAndBook;


public interface RatingServiceFeign {

    RatingAndBook findById(Long id) throws Exception;
}
