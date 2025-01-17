package com.ouaskanas.hahn.service.interfaces;

import com.ouaskanas.hahn.dao.entities.Employees;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employees> findAll();
    public Employees findById(int id);
    public Employees save(Employees employees);
    public void deleteById(int id);
    public Employees update(Employees employees, int id);
}
