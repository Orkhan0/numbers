package com.company.test.service;

import com.company.test.model.Employee;
import com.company.test.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return (List<Employee>) repo.findAll();
    }

    public void save(Employee employee) {
        repo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return (List<Employee>) repo.findAll();
    }

    public void saveAll(List<Employee> listEmployee) {
        repo.saveAll(listEmployee);
    }
}