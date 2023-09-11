package com.reto.business.rating.service.impl;

import com.reto.business.rating.entity.RatingEntity;
import com.reto.business.rating.repository.RatingRepository;
import com.reto.business.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService

{

    @Autowired
    private RatingRepository repository;

    @Override
    public List<RatingEntity> findAll() {
        return (List<RatingEntity>) repository.findAll();
    }

    @Override
    public RatingEntity findById(Long id) throws Exception {
        Optional<RatingEntity> rating = repository.findById(id);

        if (rating.isPresent()){
            return  rating.get();
        } else {
            throw new Exception("No Exist Rating");
        }

    }

    @Override
    public boolean delete(Long id) {
        Optional<RatingEntity> rating = repository.findById(id);

        if (rating.isPresent()){
            repository.deleteById(id);
            return  true;
        } else {
            return false;
        }
    }

    @Override
    public RatingEntity save(RatingEntity rating) {
        return repository.save(rating);
    }

    @Override
    public RatingEntity edit(RatingEntity rating) {
        return repository.save(rating);
    }


}
