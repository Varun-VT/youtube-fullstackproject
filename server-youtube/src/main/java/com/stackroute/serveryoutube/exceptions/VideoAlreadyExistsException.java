package com.stackroute.serveryoutube.exceptions;

public class VideoAlreadyExistsException extends Exception{

    private String message;

    public VideoAlreadyExistsException(){}

    public VideoAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
