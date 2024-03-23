package com.comfama.project.infrastructure.controllers;


import com.comfama.project.application.dto.ReceivedProposalDTO;
import com.comfama.project.application.service.receivedProposal.ReceivedProposalService;
import com.comfama.project.domain.models.ReceivedProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/received_proposals")
public class ReceivedProposalController implements IMethodsController<ReceivedProposal, ReceivedProposalDTO,Long> {

    @Autowired
    private ReceivedProposalService service;


    @Override
    @GetMapping
    public ResponseEntity<Iterable<?>> getAll() {
        return new ResponseEntity<>(service.getReceivedProposals().get(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id) {
        return new ResponseEntity<>(service.getReceivedProposal(id).get(),HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<?> create(ReceivedProposalDTO dto) {
        return new ResponseEntity<>(service.createReceivedProposal(dto),HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(Long id, ReceivedProposalDTO dto) {
        return service.updateReceivedProposal(id,dto)
                .map(proposer -> new ResponseEntity<>(proposer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        if(service.deleteReceivedProposal(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
