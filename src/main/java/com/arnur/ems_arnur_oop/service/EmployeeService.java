package com.arnur.ems_arnur_oop.service;

import com.arnur.ems_arnur_oop.api.model.Employee;
import com.arnur.ems_arnur_oop.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
    public Long addEmployee(Employee employee) {
        return employeeRepo.addEmployee(employee.getName(), employee.getPosition(), employee.getSalary());
    }
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " not found"));
    }
}


