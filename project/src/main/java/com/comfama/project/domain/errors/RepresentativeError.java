package com.comfama.project.domain.errors;

public class RepresentativeError {

    private String errorMessage;

    public RepresentativeError() {
    }

    public RepresentativeError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
