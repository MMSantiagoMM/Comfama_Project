package com.comfama.project.infrastructure.controllers;


import com.comfama.project.application.dto.ProposalDTO;
import com.comfama.project.application.service.proposal.ProposalService;
import com.comfama.project.domain.models.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/proposals")
public class ProposalController implements IMethodsController<Proposal, ProposalDTO,Integer>{

    @Autowired
    private ProposalService service;


    @Override
    @GetMapping
    public ResponseEntity<Iterable<?>> getAll() {
        return new ResponseEntity<>(service.getProposals().get(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Integer id) {
        return new ResponseEntity<>(service.getProposal(id).get(),HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<?> create(ProposalDTO proposalDTO) {
        return new ResponseEntity<>(service.createProposal(proposalDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, ProposalDTO dto){
        return service.updateProposal(id,dto)
                .map(proposer -> new ResponseEntity<>(proposer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Integer id) {
        if(service.deleteProposal(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
