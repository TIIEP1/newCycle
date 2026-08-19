package com.NewCycle.cashtrash.model.exception;

public class TrashcanNotFoundException extends RuntimeException {
    public TrashcanNotFoundException(Long id) {
        super("trashcan with id: "+id+" Not found");
    }
}
