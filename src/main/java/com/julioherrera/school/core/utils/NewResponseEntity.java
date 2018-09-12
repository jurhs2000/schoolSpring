package com.julioherrera.school.core.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NewResponseEntity {
    public ResponseEntity<String> json(String message, HttpStatus status) {
        return new ResponseEntity<String>("{\"message\":\""+ message + "\"}", status);
    }
}
