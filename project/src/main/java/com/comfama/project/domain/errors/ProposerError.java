package com.comfama.project.domain.errors;

public class ProposerError {

    private String errorMessage;

    public ProposerError() {
    }

    public ProposerError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
