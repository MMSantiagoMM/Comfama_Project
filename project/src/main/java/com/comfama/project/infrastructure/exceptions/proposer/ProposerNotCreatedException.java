package com.comfama.project.infrastructure.exceptions.proposer;

public class ProposerNotCreatedException extends RuntimeException{
    public ProposerNotCreatedException(String message){
        super(message);
    }
}
