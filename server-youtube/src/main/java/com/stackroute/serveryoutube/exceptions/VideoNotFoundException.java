package com.stackroute.serveryoutube.exceptions;

public class VideoNotFoundException extends Exception{
    private String message;

    public VideoNotFoundException(){}

    public VideoNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
