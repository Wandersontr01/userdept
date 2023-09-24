package com.exercicio.userdept.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//MAPEAMENTO ORM
@Entity //Informa ao Banco que que essa classe é uma entidade mapeada pelo Banco
@Table(name = "tb_user")//Informa o nome da tabela no Banco

public class User {
	
	@Id //Informa que essa variavel sera a chave primaria do banco
	@GeneratedValue(strategy = GenerationType.IDENTITY) //cria um valor automatico
	private Long id;
	private String name;
	private String email;
	
	@ManyToOne //relacao muitos para um entre User e Department
	@JoinColumn(name = "department_id") //configura o nome da chav estrangeira do banco
	private Department department;
	
	public User() {
		
	}
	
	//Getters
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Department getDepartment() {
		return department;
	}

	//Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
	
}
