package com.comfama.project.infrastructure.exceptions.proposer;

public class ProposersNotFoundException extends RuntimeException{
    public ProposersNotFoundException(){
        super("No proposer was found");
    }
}
