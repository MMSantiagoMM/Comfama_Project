package com.comfama.project.infrastructure.controllers;


import com.comfama.project.application.dto.ProposerDTO;
import com.comfama.project.application.service.proposer.ProposerService;
import com.comfama.project.domain.models.Proposer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/proposers")
public class ProposerController implements IMethodsController<Proposer, ProposerDTO, Long>{


    @Autowired
    ProposerService service;

    @Override
    @GetMapping
    public ResponseEntity<Iterable<?>> getAll() {
        return new ResponseEntity<>(service.getProposers().get(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id) {
        return new ResponseEntity<>(service.getProposer(id),HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<?> create(ProposerDTO proposerDTO) {
        return new ResponseEntity<>(service.createProposer(proposerDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProposerDTO dto){
        return service.updateProposer(id,dto)
                .map(proposer -> new ResponseEntity<>(proposer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        if(service.deleteProposer(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
