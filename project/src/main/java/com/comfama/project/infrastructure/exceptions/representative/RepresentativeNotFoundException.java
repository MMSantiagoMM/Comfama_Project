package com.comfama.project.infrastructure.exceptions.representative;

import java.util.UUID;

public class RepresentativeNotFoundException extends RuntimeException{

    public RepresentativeNotFoundException(Integer id){
        super("The representative with the id: " + id + " was not found");
    }

}
