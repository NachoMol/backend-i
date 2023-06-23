package com.example.clase23.exception;

public class BadRequestException extends Exception{

    public BadRequestException(String mensaje){
        super(mensaje);
    }

}
