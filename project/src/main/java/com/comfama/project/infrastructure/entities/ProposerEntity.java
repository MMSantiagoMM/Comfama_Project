package com.comfama.project.infrastructure.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "proposers")
public class ProposerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proposer")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url_documents")
    private String urlDocuments;

    @Column(name = "trajectory_description")
    private String trajectoryDescription;

    @Column(name = "type_of_proposer")
    private String typeOfProposer;

    @Column(name = "allied_companies")
    private String alliedCompanies;


    public ProposerEntity() {
    }

    public ProposerEntity(Long id, String name, String urlDocuments, String trajectoryDescription,
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
