package com.comfama.project.application.messages;

public enum MessageExc {
    NAME("Name is required"),
    DESCRIPTION_PROPOSAL("The description of the proposal is required"),
    DESCRIPTION_ACTIVITY("The description of activities is required"),
    FOCUSED_PEOPLE("People who the activity are for is a required field"),
    DATE("Date must not be empty or wrong"),
    MONEY("The amount of money is required"),
    PROPOSER("A proposer is required"),
    TYPE_PROPOSER("The type of proposer is required"),
    COMPANIES("Allied companies are required"),
    TRAJECTORY("The trajectory is required"),
    URL("The document's url is required"),
    PROPOSAL("A proposal is required"),
    REPRESENTATIVE("A representative is required"),
    LAST_NAME("Last name is required"),
    EMAIL("Email is required"),
    CELLPHONE("Cellphone number is required"),
    TELEPHONE("Telephone is required"),
    TYPE_DOCUMENT("Type of document is required");

    public String message;

    MessageExc(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
