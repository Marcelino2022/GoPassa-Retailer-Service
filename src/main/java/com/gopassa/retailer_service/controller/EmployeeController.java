package com.gopassa.retailer_service.controller;

import com.gopassa.retailer_service.application.dto.domainDTO.EmployeeDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.createDTO.CreateEmployeeDTO;
import com.gopassa.retailer_service.application.dto.requestDTO.updateDTO.UpdateEmployeeDTO;
import com.gopassa.retailer_service.application.services.EmployeeService;
import com.gopassa.retailer_service.domain.entities.Employee;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employees = employeeService.findAll();

        List<EmployeeDTO> employeeDTO = employees
                .stream()
                .map(EmployeeDTO::create)
                .toList();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody @Valid CreateEmployeeDTO createEmployeeDTO){
        Employee employee = employeeService.create(createEmployeeDTO);
        return ResponseEntity.created(URI.create("employees/"+employee.getId()))
                .body(EmployeeDTO.create(employee));
    }


    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable @Valid String id){
        Employee employee = employeeService.findById(id);
        return  ResponseEntity.ok(EmployeeDTO.create(employee));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable @Valid String id,
                                              @RequestBody @Valid UpdateEmployeeDTO updateEmployeeDTO){
        Employee employee = employeeService.update(id,updateEmployeeDTO);
        return ResponseEntity.ok(EmployeeDTO.create(employee));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Valid String id){
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
