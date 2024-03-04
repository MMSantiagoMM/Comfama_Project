package com.comfama.project.infrastructure.controllers;

import com.comfama.project.application.dto.RepresentativeDTO;
import com.comfama.project.application.service.representative.RepresentativeService;
import com.comfama.project.domain.models.Representative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("representative")
public class RepresentativeController implements IMethodsController<Representative,RepresentativeDTO,Integer>{

    @Autowired
    private RepresentativeService service;


    @Override
    @GetMapping
    public ResponseEntity<Iterable<Representative>> getAll() {
        return new ResponseEntity<>(service.getRepresentatives(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Representative> getOne(Integer id) {
        return new ResponseEntity<>(service.getRepresentativeById(id),HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<Representative> create(RepresentativeDTO dto) {
        return new ResponseEntity<>(service.saveRepresentative(dto),HttpStatus.CREATED);
    }


    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Integer id) {
        if(service.deleteRepresentative(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
