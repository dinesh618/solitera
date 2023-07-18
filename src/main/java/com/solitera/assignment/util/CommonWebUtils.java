package com.solitera.assignment.util;

import com.solitera.assignment.response.FailureResponse;
import com.solitera.assignment.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CommonWebUtils {

    public ResponseEntity<?> successResponse(String message)
    {
        SuccessResponse response = new SuccessResponse();

        response.setMessage(message);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    public static ResponseEntity<?> failureResponse(String message, int code)
    {
        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setCode(code);
        failureResponse.setMessage(message);
        return new ResponseEntity<>(failureResponse,HttpStatus.BAD_REQUEST);
    }



}
