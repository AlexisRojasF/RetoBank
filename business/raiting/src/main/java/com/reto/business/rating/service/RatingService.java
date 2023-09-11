package com.reto.business.rating.service;

import com.reto.business.rating.entity.RatingEntity;

import java.util.List;

public interface RatingService {

    List<RatingEntity> findAll ();
    RatingEntity findById(Long id) throws Exception;
    boolean delete(Long id);
    RatingEntity save(RatingEntity rating);

    RatingEntity edit(RatingEntity rating);
}
