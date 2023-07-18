package com.solitera.assignment.response;

import lombok.Data;

@Data
public class FailureResponse {
    private String message;
    private int code;
}
