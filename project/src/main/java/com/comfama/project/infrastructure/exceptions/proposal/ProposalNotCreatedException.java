package com.comfama.project.infrastructure.exceptions.proposal;

public class ProposalNotCreatedException extends RuntimeException{
    public ProposalNotCreatedException(String message){
        super(message);
    }
}
