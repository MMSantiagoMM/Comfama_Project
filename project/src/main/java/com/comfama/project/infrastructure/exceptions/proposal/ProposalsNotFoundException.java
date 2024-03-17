package com.comfama.project.infrastructure.exceptions.proposal;

public class ProposalsNotFoundException extends RuntimeException{

    public ProposalsNotFoundException(){
        super("None of proposals were found");
    }
}
