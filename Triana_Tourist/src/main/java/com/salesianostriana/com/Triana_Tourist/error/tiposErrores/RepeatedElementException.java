package com.salesianostriana.com.Triana_Tourist.error.tiposErrores;

public class RepeatedElementException extends RuntimeException{

    public RepeatedElementException (Class c){
        super(String.format("No se pueden repetir los elementos del tipo %s", c.getName()));
    }

}
