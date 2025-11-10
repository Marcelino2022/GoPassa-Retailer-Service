package com.gopassa.retailer_service.application.services;

import com.gopassa.retailer_service.application.dto.domainDTO.EmployeeDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateEmployeeDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateEmployeeDTO;
import com.gopassa.retailer_service.domain.entities.Employee;
import com.gopassa.retailer_service.domain.entities.Retailer;
import com.gopassa.retailer_service.repository.EmployeeRepository;
import com.gopassa.retailer_service.repository.RetailerRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RetailerService retailerService;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee create(CreateEmployeeDTO createEmployeeDTO) {

        Retailer retailer = retailerService.findById(createEmployeeDTO.getRetailerId());

        Employee employee = Employee.builder()
                .firstName(createEmployeeDTO.getFirstName())
                .lastName(createEmployeeDTO.getLastName())
                .email(createEmployeeDTO.getEmail())
                .mobileNumber(String.valueOf(createEmployeeDTO.getMobileNumber()))
                .position(createEmployeeDTO.getPosition())
                .tenantId(createEmployeeDTO.getTenantId())
                .userId(createEmployeeDTO.getUserId())
                .retailer(retailer)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return employeeRepository.save(employee);
    }


    public Employee findById(String id){

        return employeeRepository.findById(id)
                .orElse( null);
    }


    public Employee update(String id, UpdateEmployeeDTO updateEmployeeDTO) {
        Employee employee = findById(id);

        employee.setFirstName(updateEmployeeDTO.getFirstName());
        employee.setLastName(updateEmployeeDTO.getLastName());
        employee.setEmail(updateEmployeeDTO.getEmail());
        employee.setMobileNumber(updateEmployeeDTO.getMobileNumber());
        employee.setPosition(updateEmployeeDTO.getPosition());
        employee.setUpdatedAt(LocalDateTime.now());

        return employee;
    }


    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }
}
