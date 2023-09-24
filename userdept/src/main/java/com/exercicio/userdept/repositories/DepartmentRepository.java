package com.exercicio.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.userdept.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
