package com.gopassa.retailer_service.repository;

import com.gopassa.retailer_service.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
