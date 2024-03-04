package com.comfama.project.infrastructure.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "representatives")
public class RepresentativeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "type_document")
    private String typeDocument;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "cel_phone")
    private String celPhone;

    @Column(name = "email")
    private String email;


    public RepresentativeEntity() {
    }

    public RepresentativeEntity(String name, String lastName, String typeDocument,
                                String telephone, String celPhone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.typeDocument = typeDocument;
        this.telephone = telephone;
        this.celPhone = celPhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(String celPhone) {
        this.celPhone = celPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
