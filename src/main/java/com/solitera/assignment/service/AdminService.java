package com.solitera.assignment.service;

import com.solitera.assignment.model.Category;
import com.solitera.assignment.model.Employee;
import com.solitera.assignment.request.*;
import com.solitera.assignment.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    ResponseEntity<?> addCategory(AddCategory category);

    ResponseEntity<?> addSubCategory(AddSubCategory category,int role_id);

    List<Category> getListOfCategory();

    ResponseEntity<?> addEmployeDetails(EmployeeDetail employeeDetail);

    List<Employee> getListOfEmployee(PageRequest pageRequest);

    EmployeeResponse getParticularEmployeeDetail(String username);

    ResponseEntity<?> updateEmployeeDetail(EmployeeRequest employeeRequest, String username);

    ResponseEntity<?> deleteEmployeeDetail(int id);
}
