package com.comfama.project.infrastructure.entities;


import com.comfama.project.domain.models.Proposal;
import com.comfama.project.domain.models.Representative;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "received_proposals")
public class ReceivedProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "representative_id")
    private Representative representative;

    @Column(name = "presentation_proposal_date")
    private LocalDate presentationProposalDate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "requested_money")
    private Double requestedMoney;

    public ReceivedProposalEntity() {
    }

    public ReceivedProposalEntity(String id, Proposal proposal, Representative representative,
                                  LocalDate presentationProposalDate, Boolean status, Double requestedMoney) {
        this.id = id;
        this.proposal = proposal;
        this.representative = representative;
        this.presentationProposalDate = presentationProposalDate;
        this.status = status;
        this.requestedMoney = requestedMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
