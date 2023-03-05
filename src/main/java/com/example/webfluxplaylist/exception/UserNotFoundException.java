package com.example.webfluxplaylist.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super(String.format("PlayList with id %d not found.", id));
    }
}
