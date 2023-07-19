package com.solitera.assignment.serviceimpl;

import com.solitera.assignment.Exception.CustomException;
import com.solitera.assignment.Repository.EmployeeRepository;
import com.solitera.assignment.Repository.SubCategoryRepostiory;
import com.solitera.assignment.Repository.CategoryRepository;
import com.solitera.assignment.constant.CommonConstant;
import com.solitera.assignment.model.Employee;
import com.solitera.assignment.model.SubCategory;
import com.solitera.assignment.model.Category;
import com.solitera.assignment.request.*;
import com.solitera.assignment.response.EmployeeResponse;
import com.solitera.assignment.service.AdminService;
import com.solitera.assignment.util.CommonWebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepostiory subCategoryRepostiory;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<?> addCategory(AddCategory category) {
        Category role = new Category();
        role.setCategory(category.getRole());
        categoryRepository.save(role);

        return CommonWebUtils.successResponse("category added successfully");
    }


    @Override
    public ResponseEntity<?> addSubCategory(AddSubCategory category, int role_id) {
        Category role = categoryRepository.getReferenceById(role_id);
        if (Objects.nonNull(role)) {

            for (String addSubCategory : category.getSubCategory()) {
                SubCategory assign = new SubCategory();
                assign.setSub_category(addSubCategory);
                assign.setRole_id(role_id);
                subCategoryRepostiory.save(assign);

            }
            return CommonWebUtils.successResponse("sub category added successfuly");


        }
        throw new CustomException("something went wrong");
    }

    @Override
    public List<Category> getListOfCategory() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new CustomException("No such record exist");
        }
        return categories;
    }

    @Override
    public ResponseEntity<?> addEmployeDetails(EmployeeDetail employeeDetail) {
        Employee employee1 = employeeRepository.findByUserName(employeeDetail.getUsername());
        if (Objects.nonNull(employee1)) {
            throw new CustomException("employee already exist");
        }
        Employee employee = new Employee();
        List<Category> categoryList = categoryRepository.findAll();


        if (Objects.nonNull(employeeDetail)) {
            employee.setName(employeeDetail.getName());
            employee.setUsername(employeeDetail.getUsername());
            employee.setPassword("password");
            employee.setRole(CommonConstant.Role.valueOf(employeeDetail.getRole()));
            if (categoryList.contains(employeeDetail.getCategory())) {
                employee.setCategory(employeeDetail.getCategory());

            } else {
                Category category = new Category();
                category.setCategory(employeeDetail.getCategory());
                categoryRepository.save(category);
                employee.setCategory(employeeDetail.getCategory());
            }
            employeeRepository.save(employee);
            return CommonWebUtils.successResponse("details of employee saved successfully");
        }
        throw new CustomException("failed to saved details of user");

    }

    @Override
    public List<Employee> getListOfEmployee(PageRequest pageRequest) {

        Specification<Employee> specification = Specification.where(null);

        if (pageRequest.getName() != null) {
            specification = specification.and(EmployeeSpecification.hasName(pageRequest.getName()));
        }

        if (pageRequest.getUsername() != null) {
            specification = specification.and(EmployeeSpecification.hasUserName(pageRequest.getUsername()));
        }
        if (pageRequest.getCategory() != null) {
            specification = specification.and(EmployeeSpecification.hasCategory(pageRequest.getCategory()));
        }

        return employeeRepository.findAll(specification);
    }

    @Override
    public EmployeeResponse getParticularEmployeeDetail(String  username) {
        Employee employee = employeeRepository.findByUserName(username);
        if (Objects.nonNull(employee)) {
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setName(employee.getName());
            employeeResponse.setUsername(employee.getUsername());
            employeeResponse.setPassword(employee.getPassword());
            employeeResponse.setRole(employee.getRole());
            employeeResponse.setCategory(employee.getCategory());
            return employeeResponse;


        }
        throw new CustomException("Error to find particular userdetails");
    }

    @Override
    public ResponseEntity<?> updateEmployeeDetail(EmployeeRequest employeeRequest, String username) {
        Employee employee = employeeRepository.findByUserName(username);
        if (Objects.nonNull(employee)) {
            employee.setName(employeeRequest.getName());
            employee.setUsername(employeeRequest.getUsername());
            employee.setCategory(employeeRequest.getCategory());
            employeeRepository.save(employee);
            return CommonWebUtils.successResponse("Updated details of employee saved Successfully");

        }
        throw new CustomException("employee with this username not exist");


    }

    @Override
    public ResponseEntity<?> deleteEmployeeDetail(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return CommonWebUtils.successResponse("employee deleted successfully");
        }
        throw new CustomException("user not exist for this employee_id");
    }
}

