package com.solitera.assignment.Repository;

import com.solitera.assignment.model.Employee;
import com.solitera.assignment.request.PageRequest;
import com.solitera.assignment.response.EmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> , JpaSpecificationExecutor<Employee> {

    @Query("SELECT p FROM Employee p WHERE p.username LIKE %:username%")
    Employee findByUserName(@Param("username") String username);
}
