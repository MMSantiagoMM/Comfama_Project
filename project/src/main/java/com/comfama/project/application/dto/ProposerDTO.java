package com.comfama.project.application.dto;

public class ProposerDTO {

    private String name;

    private String urlDocuments;

    private String trajectoryDescription;

    private String typeOfProposer;

    private String alliedCompanies;

    public ProposerDTO() {
    }

    public ProposerDTO(String name, String urlDocuments, String trajectoryDescription,
                    String typeOfProposer, String alliedCompanies) {
        this.name = name;
        this.urlDocuments = urlDocuments;
        this.trajectoryDescription = trajectoryDescription;
        this.typeOfProposer = typeOfProposer;
        this.alliedCompanies = alliedCompanies;
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
