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


import com.exercicio.userdept.entities.User;
import com.exercicio.userdept.repositories.UserRepository;

import jakarta.transaction.Transactional;

@RestController //Informa que essa class é um controlador REST
@RequestMapping(value = "/users") //Informa qual caminho o controlador vai responder
public class UserController {
	
	@Autowired //Injecao de dependecia, instancia automaticamente o UserRepository
	private UserRepository repository;
	
	//READ ALL
	//Endpoint para mostrar todos os usuarios do Banco
	@GetMapping //informa que essa é uma requisicao HTTP GET
	public List<User> findAll(){
		List<User> result = repository.findAll();
		return result;
	}
	
	//READ ID
	//Endpoint para buscar um usuario por ID no banco
	@GetMapping(value = "/{id}") //informa que é uma requisicao HTTP GET e indica que o caminho é /users/numero que é o ID
	public User findById(@PathVariable Long id){
		User result = repository.findById(id).get();
		return result;
	}
	
	//CREATE
	//Endpoint para salvar um novo usuario no Banco
	@PostMapping 
	public User insert(@RequestBody User user){
		User result = repository.save(user);
		return result;
	}
	
	//DELETE
	//Endpoint para deletar um usuario no Banco
	@DeleteMapping(value = "/delete")
	public void delete(@RequestBody User usuario){
		repository.delete(usuario);
					
	}
	
	//UPDATE
	@PutMapping(value = "/update")
	@Transactional
	public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
	    Optional<User> user_updt = repository.findById(userDTO.getId());
	    
	    if (user_updt.isPresent()) {
	        User user = user_updt.get();
	        user.setName(userDTO.getName());
	        user.setEmail(userDTO.getEmail());
	        user.setDepartment(userDTO.getDepartment());
	        return ResponseEntity.ok(user);    
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
}
