package com.solitera.assignment.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequest {
    @NotNull(message =" must provide name")
    private String name;
    @Email
    @NotNull(message= "must provide valid email")
    private String username;
    @NotNull(message= "category not be empty")
    private String category;
    @NotNull(message= "password not be null")
    private String password;
}
