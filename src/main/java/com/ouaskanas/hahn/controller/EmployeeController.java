package com.ouaskanas.hahn.controller;

import com.ouaskanas.hahn.dao.entities.Employees;
import com.ouaskanas.hahn.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getall")
    public List<Employees> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/get/{id}")
    public Employees getEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/create")
    public Employees createEmployee(@RequestBody Employees employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/alter/{id}")
    public Employees updateEmployee(@RequestBody Employees employee, @PathVariable int id) {
        return employeeService.update(employee, id);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
    }


}
