package com.comfama.project.domain.models;

import com.comfama.project.infrastructure.entities.ProposalEntity;

import java.time.LocalDate;

public class ReceivedProposal {

    private Proposal proposal;

    private Representative representative;

    private LocalDate presentationProposalDate;

    private Boolean status;

    private Double requestedMoney;


    public ReceivedProposal() {
    }

    public ReceivedProposal(Proposal proposal, Representative representative,
                            LocalDate presentationProposalDate, Boolean status, Double requestedMoney) {
        this.proposal = proposal;
        this.representative = representative;
        this.presentationProposalDate = presentationProposalDate;
        this.status = status;
        this.requestedMoney = requestedMoney;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Representative getRepresentative() {
        return representative;
    }

    public void setRepresentative(Representative representative) {
        this.representative = representative;
    }

    public LocalDate getPresentationProposalDate() {
        return presentationProposalDate;
    }

    public void setPresentationProposalDate(LocalDate presentationProposalDate) {
        this.presentationProposalDate = presentationProposalDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getRequestedMoney() {
        return requestedMoney;
    }

    public void setRequestedMoney(Double requestedMoney) {
        this.requestedMoney = requestedMoney;
    }
}
