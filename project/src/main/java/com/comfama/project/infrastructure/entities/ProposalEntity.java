package com.comfama.project.infrastructure.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "proposals")
public class ProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description_activities")
    private String descriptionActivities;

    @Column(name = "description_proposal")
    private String descriptionProposal;

    @Column(name = "focused_public")
    private String focusedPeople;

    @Column(name = "beginning_activity_date")
    private LocalDate beginningDate;

    @Column(name = "total_money")
    private Double totalMoney;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposer_id")
    private ProposerEntity proposer;


    public ProposalEntity() {
    }

    public ProposalEntity(Integer id, String name, String descriptionActivities, String descriptionProposal, String focusedPeople,
                          LocalDate beginningDate, Double totalMoney, ProposerEntity proposer) {
        this.id = id;
        this.name = name;
        this.descriptionActivities = descriptionActivities;
        this.descriptionProposal = descriptionProposal;
        this.focusedPeople = focusedPeople;
        this.beginningDate = beginningDate;
        this.totalMoney = totalMoney;
        this.proposer = proposer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionActivities() {
        return descriptionActivities;
    }

    public void setDescriptionActivities(String descriptionActivities) {
        this.descriptionActivities = descriptionActivities;
    }

    public String getDescriptionProposal() {
        return descriptionProposal;
    }

    public void setDescriptionProposal(String descriptionProposal) {
        this.descriptionProposal = descriptionProposal;
    }

    public String getFocusedPeople() {
        return focusedPeople;
    }

    public void setFocusedPeople(String focusedPeople) {
        this.focusedPeople = focusedPeople;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public ProposerEntity getProposer() {
        return proposer;
    }

    public void setProposer(ProposerEntity proposer) {
        this.proposer = proposer;
    }
}
