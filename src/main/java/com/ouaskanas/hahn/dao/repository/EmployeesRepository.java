package com.ouaskanas.hahn.dao.repository;

import com.ouaskanas.hahn.dao.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}
