package com.solitera.assignment.controller;

import com.solitera.assignment.constant.ResponseCode;
import com.solitera.assignment.model.Employee;
import com.solitera.assignment.request.EmployeeDetail;
import com.solitera.assignment.request.EmployeeRequest;
import com.solitera.assignment.request.LoginRequest;
import com.solitera.assignment.service.UserService;
import com.solitera.assignment.util.CommonWebUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@Validated @RequestBody LoginRequest loginRequest) {
        ResponseEntity<?> response =null;

        try {
            response = userService.userLogin(loginRequest);
        } catch (Exception e) {

            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.ADD_EMPLOYEE_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(response);

    }



    @PostMapping("/view/detail")
    public ResponseEntity<?> employeeViewAccountDetails(@RequestParam  String username) {
         EmployeeDetail employeeDetail = null;

        try {
            employeeDetail = userService.employeeViewAccountDetails(username);
        } catch (Exception e) {

            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.ADD_EMPLOYEE_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(employeeDetail);

    }

    @PutMapping("/update/detail")
    public ResponseEntity<?> employeeUpdateDetail( @RequestParam  String username, @RequestBody  @Valid EmployeeRequest employeeRequest) {
        ResponseEntity<?> response = null;

        try {
            response = userService.employeeUpdateDetail(username,employeeRequest);
        } catch (Exception e) {

            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.ADD_EMPLOYEE_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(response);

    }

}
