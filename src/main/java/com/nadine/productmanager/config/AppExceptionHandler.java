package com.nadine.productmanager.config;

import com.nadine.productmanager.exceptions.BadRequestException;
import com.nadine.productmanager.exceptions.OrderNotFoundException;
import com.nadine.productmanager.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public final ResponseEntity<String> handle(OrderNotFoundException exception) {
        return ResponseEntity.status(404).body("order not found - exception handler");
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<String> handle(BadRequestException exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<String> handle(ProductNotFoundException exception) {
        return ResponseEntity.status(404).body("product not found - exception handler");
    }

}
