package com.linktracker.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LinkIdNotFoundException extends ResponseStatusException {

    public LinkIdNotFoundException(String linkId) {
        super(HttpStatus.NOT_FOUND,"LinkID: " + linkId + " não cadastrado");
    }
}
