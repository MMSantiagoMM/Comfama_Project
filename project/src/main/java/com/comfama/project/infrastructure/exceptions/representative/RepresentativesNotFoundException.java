package com.comfama.project.infrastructure.exceptions.representative;

public class RepresentativesNotFoundException extends RuntimeException{

    public RepresentativesNotFoundException(){
        super("No representative was found");
    }
}
