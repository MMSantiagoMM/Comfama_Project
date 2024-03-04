package com.comfama.project.domain.models;

import java.time.LocalDate;

public class Proposal {

    private String name;

    private String descriptionActivities;

    private String descriptionProposal;

    private String focusedPeople;

    private LocalDate beginningDate;

    private Double totalMoney;

    private Proposer proposer;


    public Proposal() {
    }

    public Proposal(String name, String descriptionActivities, String descriptionProposal,
                    String focusedPeople, LocalDate beginningDate, Double totalMoney, Proposer proposer) {
        this.name = name;
        this.descriptionActivities = descriptionActivities;
        this.descriptionProposal = descriptionProposal;
        this.focusedPeople = focusedPeople;
        this.beginningDate = beginningDate;
        this.totalMoney = totalMoney;
        this.proposer = proposer;
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

    public Proposer getProposer() {
        return proposer;
    }

    public void setProposer(Proposer proposer) {
        this.proposer = proposer;
    }
}
