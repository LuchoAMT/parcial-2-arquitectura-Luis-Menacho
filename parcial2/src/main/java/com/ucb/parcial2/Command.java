package com.ucb.parcial2;

import org.springframework.http.ResponseEntity;

public interface Command<I,O> {
    ResponseEntity<O> execute(I input);
}
