package com.comfama.project.domain.models;

public class Representative {


    private String name;

    private String lastName;

    private String typeDocument;

    private String telephone;

    private String celPhone;

    private String email;

    public Representative() {
    }

    public Representative(String name, String lastName, String typeDocument, String telephone,
                          String celPhone, String email) {
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
