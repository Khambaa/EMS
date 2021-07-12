package com.catalyst.assignment.exceptions.handler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class RestError {
    private Integer internalCode;
    private Integer status;
    private String message;

    public RestError(Integer internalCode, Integer status, String message) {
        this.internalCode = internalCode;
        this.status = status;
        this.message = message;
    }
}
