package com.solitera.assignment.response;

import com.solitera.assignment.constant.CommonConstant;
import com.solitera.assignment.model.SubCategory;
import lombok.Data;

import java.util.List;

@Data

public class EmployeeResponse {

    private String name;
    private String username;
    private String password;
    private CommonConstant.Role role;
    private String category;

}
