package com.comfama.project.application.dto;

import com.comfama.project.domain.models.Proposal;
import com.comfama.project.domain.models.Representative;

import java.time.LocalDate;

public class ReceivedProposalDTO {

    private Integer idProposal;

    private Integer idRepresentative;

    private LocalDate presentationProposalDate;

    private Boolean status;

    private Double requestedMoney;


    public ReceivedProposalDTO() {
    }

    public ReceivedProposalDTO(Integer idProposal, Integer idRepresentative,
                               LocalDate presentationProposalDate, Boolean status,
                               Double requestedMoney) {
        this.idProposal = idProposal;
        this.idRepresentative = idRepresentative;
        this.presentationProposalDate = presentationProposalDate;
        this.status = status;
        this.requestedMoney = requestedMoney;
    }


    public Integer getIdProposal() {
        return idProposal;
    }

    public void setIdProposal(Integer idProposal) {
        this.idProposal = idProposal;
    }

    public Integer getIdRepresentative() {
        return idRepresentative;
    }

    public void setIdRepresentative(Integer idRepresentative) {
        this.idRepresentative = idRepresentative;
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
