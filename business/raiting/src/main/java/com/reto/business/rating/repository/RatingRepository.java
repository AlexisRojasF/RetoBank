package com.reto.business.rating.repository;


import com.reto.business.rating.entity.RatingEntity;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<RatingEntity,Long> {
}
