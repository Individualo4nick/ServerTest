package com.example.servertest.Exception_handling;

public class NoSuchEntityException extends RuntimeException{
    public NoSuchEntityException(String message){
        super(message);
    }
}
