package com.comfama.project.domain.errors;

import java.util.List;
import java.util.Optional;

public class ProposalError {

    private String errorMessage;

    public ProposalError() {
    }

    public ProposalError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
