package com.catalyst.assignment.exceptions;

public class AppRuntimeException extends RuntimeException{

    private Exception exception;
    private ErrorCode errorCode;
    private String description;

    public AppRuntimeException(Exception exception, ErrorCode errorCode, String description) {
        this.exception = exception;
        this.errorCode = errorCode;
        this.description = description;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
