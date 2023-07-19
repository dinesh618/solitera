package com.solitera.assignment.service;

import com.solitera.assignment.model.Employee;
import com.solitera.assignment.request.EmployeeDetail;
import com.solitera.assignment.request.EmployeeRequest;
import com.solitera.assignment.request.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    EmployeeDetail employeeViewAccountDetails( String username);

    ResponseEntity<?> userLogin(LoginRequest loginRequest);

    ResponseEntity<?>  employeeUpdateDetail(String username,EmployeeRequest employeeRequest);
}
