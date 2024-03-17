package com.comfama.project.domain.errors;

public class ReceivedProposalError {

    private String errorMessage;

    public ReceivedProposalError() {
    }

    public ReceivedProposalError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
