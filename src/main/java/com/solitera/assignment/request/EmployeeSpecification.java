package com.solitera.assignment.request;

import com.solitera.assignment.model.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {


        public static Specification<Employee> hasName(String name) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
        }

        public static Specification<Employee> hasUserName(String username) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), username);

        }
    public static Specification<Employee> hasCategory(String category) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), category);

    }

        // Additional specifications
    }

