package com.company.test.api;

import com.company.test.model.Employee;
import com.company.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/numbers")
public class EmployeeControllerThm {

    @Autowired
    EmployeeService service;

    @RequestMapping(path = {"/","/search"})
    public String home(Employee employee, Model model, String keyword){
        if (keyword!=null){
            List<Employee> list = service.listAll(keyword);
            model.addAttribute("list", list);
        }else{
            List<Employee> list = service.findAllEmployees();
            model.addAttribute("list", list);
        }
        return "index";
    }

}