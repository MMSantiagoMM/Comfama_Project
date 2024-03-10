package com.comfama.project.infrastructure.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "received_proposals")
public class ReceivedProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposal_id")
    private ProposalEntity proposal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "representative_id")
    private RepresentativeEntity representative;

    @Column(name = "presentation_proposal_date")
    private LocalDate presentationProposalDate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "requested_money")
    private Double requestedMoney;

    public ReceivedProposalEntity() {
    }

    public ReceivedProposalEntity( ProposalEntity proposal, RepresentativeEntity representative,
                                  LocalDate presentationProposalDate, Boolean status, Double requestedMoney) {

        this.proposal = proposal;
        this.representative = representative;
        this.presentationProposalDate = presentationProposalDate;
        this.status = status;
        this.requestedMoney = requestedMoney;
    }


    public ProposalEntity getProposal() {
        return proposal;
    }

    public void setProposal(ProposalEntity proposal) {
        this.proposal = proposal;
    }

    public RepresentativeEntity getRepresentative() {
        return representative;
    }

    public void setRepresentative(RepresentativeEntity representative) {
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
