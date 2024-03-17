package com.comfama.project.infrastructure.exceptions.proposal;

public class ProposalNotFoundException extends RuntimeException{

    public ProposalNotFoundException(Integer id){
        super("Proposal with the id: " + id + " was  not found");
    }
}
