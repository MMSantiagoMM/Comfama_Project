package com.comfama.project.infrastructure.exceptions;

import com.comfama.project.infrastructure.entities.ProposerEntity;

public class ProposerNotFoundException extends RuntimeException{

    public ProposerNotFoundException(Long id){
        super("Proposer with id: " + id + " was not found");
    }
}
