package com.company.test.api;

import com.company.test.model.Employee;
import com.company.test.resp.GenericResponse;
import com.company.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/all")
    public GenericResponse addEmployeesList(@RequestBody List<Employee> employeeList) {
        service.saveAll(employeeList);
        return new GenericResponse("Employee List Added");
    }

    @PostMapping
    public GenericResponse addEmployee(@RequestBody Employee employee) {
        service.save(employee);
        return new GenericResponse("Employee Added");
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees() {
        return ResponseEntity.ok(service.findAllEmployees());
    }

    @GetMapping("/{keyword}")
    public ResponseEntity<List<Employee>> searchEmployee(@PathVariable String keyword) {
        List<Employee> listEmployees = service.listAll(keyword);
        return ResponseEntity.ok(listEmployees);
    }


}