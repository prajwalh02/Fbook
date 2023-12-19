package com.example.FriendBook.exception;

public class DuplicateKeyException extends RuntimeException{

    public DuplicateKeyException(String message) {
        super(message);
    }
}
