package com.solitera.assignment.model;

import com.solitera.assignment.constant.CommonConstant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


        private String name;

        private String username;

        private String password;

       private  CommonConstant.Role role;

        private String category;




}
