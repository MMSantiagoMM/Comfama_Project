package com.comfama.project.domain.models;

public class Proposer {

    private Long id;

    private String name;

    private String urlDocuments;

    private String trajectoryDescription;

    private String typeOfProposer;

    private String alliedCompanies;

    public Proposer() {
    }

    public Proposer(Long id,String name, String urlDocuments, String trajectoryDescription,
                    String typeOfProposer, String alliedCompanies) {
        this.id = id;
        this.name = name;
        this.urlDocuments = urlDocuments;
        this.trajectoryDescription = trajectoryDescription;
        this.typeOfProposer = typeOfProposer;
        this.alliedCompanies = alliedCompanies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlDocuments() {
        return urlDocuments;
    }

    public void setUrlDocuments(String urlDocuments) {
        this.urlDocuments = urlDocuments;
    }

    public String getTrajectoryDescription() {
        return trajectoryDescription;
    }

    public void setTrajectoryDescription(String trajectoryDescription) {
        this.trajectoryDescription = trajectoryDescription;
    }

    public String getTypeOfProposer() {
        return typeOfProposer;
    }

    public void setTypeOfProposer(String typeOfProposer) {
        this.typeOfProposer = typeOfProposer;
    }

    public String getAlliedCompanies() {
        return alliedCompanies;
    }

    public void setAlliedCompanies(String alliedCompanies) {
        this.alliedCompanies = alliedCompanies;
    }
}
