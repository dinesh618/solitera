package com.solitera.assignment.controller;

import com.solitera.assignment.constant.ResponseCode;
import com.solitera.assignment.model.Category;
import com.solitera.assignment.model.Employee;
import com.solitera.assignment.request.*;
import com.solitera.assignment.response.EmployeeResponse;
import com.solitera.assignment.service.AdminService;
import com.solitera.assignment.util.CommonWebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add/category")
    public ResponseEntity<?> addDetailsOfEmployee(@RequestBody AddCategory category) {
        ResponseEntity<?> response = null;
        try {
            response = adminService.addCategory(category);
        } catch (Exception e) {
            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.ADD_CATEGORY_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(response);

    }

    @PostMapping("/add/subcategory")
    public ResponseEntity<?> addDetailsOfEmployee(@RequestBody AddSubCategory category, @RequestParam int role_id) {
        ResponseEntity<?> response = null;
        try {
            response = adminService.addSubCategory(category, role_id);
        } catch (Exception e) {
            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.ADD_SUBCATEGORY_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(response);

    }

    @GetMapping("/category/list")
    public ResponseEntity<?> getListOfCategoryWithSubCategory() {
        List<Category> categoryList = null;
        try {
            categoryList = adminService.getListOfCategory();
        } catch (Exception e) {
            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.GET_CATEGORYLIST_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(categoryList);

    }

    @PostMapping("/add/employee")
    public ResponseEntity<?> addEmployeDetails(@RequestBody EmployeeDetail employeeDetail) {
        ResponseEntity<?> response = null;
        try {
            response = adminService.addEmployeDetails(employeeDetail);
        } catch (Exception e) {

            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.ADD_EMPLOYEE_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(response);

    }

    @GetMapping("/employee/list")

    public ResponseEntity<?> getListOfEmployee(PageRequest pageRequest) {
        List<Employee> employeeResponseList = null;
        try {
            employeeResponseList = adminService.getListOfEmployee(pageRequest);
        } catch (Exception e) {
            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.GET_EMPLOYEE_LIST_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(employeeResponseList);

    }
    @GetMapping("/view/employee/detail")
    public ResponseEntity<?> getParticularEmployeeDetail(@RequestParam String username)
    {
        EmployeeResponse employeeResponse = null;
        try
        {
            employeeResponse = adminService.getParticularEmployeeDetail(username);
        }
     catch (Exception e) {
        return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.GET_EMPLOYEE_LIST_ERROR_CODE);
    }

        return CommonWebUtils.successResponse(employeeResponse);

    }

    @PutMapping("/update/employee/detail")
    public ResponseEntity<?> updateEmployeeDetail(@RequestBody EmployeeRequest employeeRequest, @RequestParam String username)
    {

        ResponseEntity<?> response = null;
        try {
            response = adminService.updateEmployeeDetail(employeeRequest, username);
        } catch (Exception e) {
            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.UPDATE_EMPLOYEE_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(response);
    }

    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<?> deleteEmployeeDetail(@PathVariable("id")int id)
    {
        ResponseEntity<?> response = null;
        try
        {
           response =   adminService.deleteEmployeeDetail(id);
        }
        catch (Exception e) {
            return CommonWebUtils.failureResponse(e.getMessage(), ResponseCode.GET_EMPLOYEE_LIST_ERROR_CODE);
        }

        return CommonWebUtils.successResponse(response);

    }



}






