package com.exercicio.userdept.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.userdept.entities.Department;
import com.exercicio.userdept.repositories.DepartmentRepository;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository repository;
	
	public DepartmentController(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}
	
	//DELETE
	@DeleteMapping(value = "/delete")
	public void delete(@RequestBody Department department){
		repository.delete(department);			
	}
	
	
	//UPDATE
	@PutMapping(value = "/update")
	@Transactional
	public ResponseEntity updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
	    Optional<Department> department_updt = repository.findById(departmentDTO.getId());
	    
	    if (department_updt.isPresent()) {
	        Department department = department_updt.get();
	        department.setName(departmentDTO.getName());
	        return ResponseEntity.ok(department);    
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	//READ ALL
	@GetMapping
	public List<Department> findAll(){
		List <Department> resultado = repository.findAll();
		return resultado;
	}
	
	//READ ID
	@GetMapping(value = "/{id}") //informa que é uma requisicao HTTP GET e indica que o caminho é /users/numero que é o ID
	public Department findById(@PathVariable Long id){
		Department result = repository.findById(id).get();
		return result;
	}
	

	//CREATE
	@PostMapping
	public Department insereNovo(@RequestBody Department novo) {
		Department resultado = repository.save(novo);
		return resultado;
	}
}
