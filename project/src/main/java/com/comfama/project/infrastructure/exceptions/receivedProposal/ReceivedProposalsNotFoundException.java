package com.comfama.project.infrastructure.exceptions.receivedProposal;

public class ReceivedProposalsNotFoundException extends RuntimeException{
    public ReceivedProposalsNotFoundException(){
        super("No received proposal was found");
    }
}
