package com.comfama.project.infrastructure.exceptions;

public class ReceivedProposalNotFoundException extends RuntimeException{

    public ReceivedProposalNotFoundException(Long id){
        super("Received Proposal with the id: " + id + " was not found");
    }
}
