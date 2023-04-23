package com.example.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapping.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
