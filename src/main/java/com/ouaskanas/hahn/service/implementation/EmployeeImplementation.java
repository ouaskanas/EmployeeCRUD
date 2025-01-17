package com.ouaskanas.hahn.service.implementation;

import com.ouaskanas.hahn.dao.entities.Employees;
import com.ouaskanas.hahn.dao.repository.EmployeesRepository;
import com.ouaskanas.hahn.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeImplementation implements EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees findById(int id) {
        if(!employeesRepository.existsById(id))
        {
            return null;
        }
        return employeesRepository.findById(id).get();
    }

    @Override
    public Employees save(Employees employees) {
        return employeesRepository.save(employees);
    }

    @Override
    public void deleteById(int id) {
        if(employeesRepository.existsById(id)) {
            employeesRepository.deleteById(id);
            System.out.println("Employee with id " + id + " deleted successfully");
        }
        System.out.println("Employee not found with id " + id);
    }

    @Override
    public Employees update(Employees employees, int id) {
        Employees employee = employeesRepository.findById(id).get();
        employee.setName(employees.getName());
        employee.setAdress(employees.getAdress());
        employee.setStatus(employees.getStatus());
        employee.setContact(employees.getContact());
        employee.setDepartment(employees.getDepartment());
        employee.setHire_date(employees.getHire_date());

        return employeesRepository.save(employee);
    }
}
