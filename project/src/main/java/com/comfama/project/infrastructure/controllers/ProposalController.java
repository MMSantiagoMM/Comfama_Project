package com.comfama.project.infrastructure.controllers;


import com.comfama.project.application.dto.ProposalDTO;
import com.comfama.project.application.service.proposal.ProposalService;
import com.comfama.project.domain.models.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("proposal")
public class ProposalController implements IMethodsController<Proposal, ProposalDTO,Integer>{

    @Autowired
    private ProposalService service;


    @Override
    @GetMapping
    public ResponseEntity<Iterable<Proposal>> getAll() {
        return new ResponseEntity<>(service.getProposals(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Proposal> getOne(Integer id) {
        return new ResponseEntity<>(service.getProposal(id).get(),HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<Proposal> create(ProposalDTO proposalDTO) {
        return new ResponseEntity<>(service.createProposal(proposalDTO),HttpStatus.CREATED);
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
