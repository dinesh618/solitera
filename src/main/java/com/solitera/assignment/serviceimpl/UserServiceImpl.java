package com.solitera.assignment.serviceimpl;

import com.solitera.assignment.Exception.CustomException;
import com.solitera.assignment.Repository.EmployeeRepository;
import com.solitera.assignment.model.Employee;
import com.solitera.assignment.request.EmployeeDetail;
import com.solitera.assignment.request.EmployeeRequest;
import com.solitera.assignment.request.LoginRequest;
import com.solitera.assignment.service.UserService;
import com.solitera.assignment.util.CommonWebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    EmployeeRepository employeeRepository;



    @Override
    public ResponseEntity<?> userLogin(LoginRequest loginRequest) {
        Employee employee = employeeRepository.findByUserName(loginRequest.getUsername());
        if(Objects.nonNull(employee))
        {
           if(employee.getUsername().equals(loginRequest.getUsername()) && loginRequest.getPassword().equals(employee.getPassword()))
               return CommonWebUtils.successResponse("login successfully");
           else
               throw new CustomException("incorrect credentials");
        }

            throw new CustomException("Username not exist");
    }

    @Override
    public EmployeeDetail employeeViewAccountDetails( String username) {
        Employee employee1 = employeeRepository.findByUserName(username);
        EmployeeDetail employee = new EmployeeDetail();
        if(Objects.nonNull(employee1))
        {
            employee.setName(employee1.getName());
            employee.setUsername(employee1.getUsername());
            employee.setPassword(employee1.getPassword());
            employee.setRole(String.valueOf(employee1.getRole()));
            employee.setCategory(employee1.getCategory());
            return employee;
        }
        throw new CustomException("User with this username is not exist");
    }
    @Override
    public ResponseEntity<?> employeeUpdateDetail(String username,EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findByUserName(username);
       if(Objects.nonNull(employee))
       {
           employee.setName(employeeRequest.getName());
           employee.setUsername(employeeRequest.getUsername());
           employee.setPassword(employeeRequest.getPassword());
           employee.setCategory(employeeRequest.getCategory());
           employeeRepository.save(employee);
           return CommonWebUtils.successResponse("employee details updated successfully ");
       }
       throw new CustomException("Employee of this username not exist");
    }
}
