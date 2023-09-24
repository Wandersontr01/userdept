package com.exercicio.userdept.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//MAPEAMENTO ORM
@Entity //Informa ao Banco que que essa classe é uma entidade mapeada pelo Banco
@Table(name = "tb_department")//Informa o nome da tabela no Banco
public class Department {
	
	@Id //Informa que essa variavel sera a chave primaria do banco
	@GeneratedValue(strategy = GenerationType.IDENTITY) //cria um valor automatico
	private Long id;
	private String name;
		
	public Department() {
		
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
