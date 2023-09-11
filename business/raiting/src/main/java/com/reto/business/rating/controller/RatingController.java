package com.reto.business.rating.controller;

import com.reto.business.rating.entity.RatingEntity;
import com.reto.business.rating.service.RatingService;
import com.reto.business.rating.service.RatingServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService service;


    @Autowired
    private RatingServiceFeign serviceFeign;

    @GetMapping()
    public List<RatingEntity> get(){
        return (List<RatingEntity>) service.findAll();
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) throws Exception {
        return serviceFeign.findById(id);
    }

    @PostMapping
    public ResponseEntity<RatingEntity> post(@RequestBody RatingEntity input){
        RatingEntity save = service.save(input);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<RatingEntity> put(@RequestBody RatingEntity input){
        RatingEntity save = service.edit(input);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        boolean x = service.delete(id);

        if (x) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Elemento Eliminado");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Elemento No Existe");
        }
    }
}
