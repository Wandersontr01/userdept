package com.exercicio.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
