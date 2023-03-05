package com.example.webfluxplaylist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ExceptionDto {

    private HttpStatus status;
    private List<String> errors;

    public ExceptionDto(HttpStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ExceptionDto(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Arrays.asList(error);
    }
}
