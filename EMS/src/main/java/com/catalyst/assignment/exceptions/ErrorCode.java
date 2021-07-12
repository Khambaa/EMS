package com.catalyst.assignment.exceptions;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    BAD_REQUEST(1,HttpStatus.BAD_REQUEST,"Some parameter is missing");


    private int code;
    private HttpStatus status;
    private String description;

    ErrorCode(int code, HttpStatus status, String description) {
        this.code = code;
        this.status = status;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
