package com.palbol.order.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderCreatedException extends RuntimeException {

    public OrderCreatedException() {
        super(String.format("La order no se pudo crear."));
    }
}
