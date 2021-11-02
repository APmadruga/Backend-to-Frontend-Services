package com.db.springlogin.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
