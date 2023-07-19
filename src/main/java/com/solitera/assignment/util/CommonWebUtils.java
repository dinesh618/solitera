package com.solitera.assignment.util;

import com.solitera.assignment.response.FailureResponse;
import com.solitera.assignment.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CommonWebUtils {

    public static ResponseEntity<?> successResponse(Object data)
    {
        SuccessResponse response = new SuccessResponse();
        return new ResponseEntity<>(data, HttpStatus.OK);

    }
    public static ResponseEntity<?> failureResponse(String message, int code)
    {
        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setCode(code);
        failureResponse.setMessage(message);
        return new ResponseEntity<>(failureResponse,HttpStatus.BAD_REQUEST);
    }



}
