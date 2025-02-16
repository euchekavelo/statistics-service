package ru.skillbox.statisticsservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.skillbox.statisticsservice.dto.response.ErrorDtoResponse;
import ru.skillbox.statisticsservice.exception.EventNotFoundException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorDtoResponse> handleNotFoundException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponseDto(ex.getMessage()));
    }

    private ErrorDtoResponse getResponseDto(String message) {
        return ErrorDtoResponse.builder()
                .message(message)
                .result(false)
                .build();
    }
}
