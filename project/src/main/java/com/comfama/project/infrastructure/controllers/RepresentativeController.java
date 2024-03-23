package com.comfama.project.infrastructure.controllers;

import com.comfama.project.application.dto.RepresentativeDTO;
import com.comfama.project.application.service.representative.RepresentativeService;
import com.comfama.project.domain.models.Representative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/representatives")
public class RepresentativeController implements IMethodsController<Representative,RepresentativeDTO,Integer>{

    @Autowired
    private RepresentativeService service;


    @Override
    @GetMapping
    public ResponseEntity<Iterable<?>> getAll() {
        return new ResponseEntity<>(service.getRepresentatives().get(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Integer id) {
        return new ResponseEntity<>(service.getRepresentativeById(id),HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<?> create(RepresentativeDTO dto) {
        return new ResponseEntity<>(service.saveRepresentative(dto),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, RepresentativeDTO dto){
        return service.updateRepresentative(id,dto)
                .map(proposer -> new ResponseEntity<>(proposer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
