package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.UserModel;

@Repository
public interface IGreetingRepo extends JpaRepository<UserModel, Long> {

}
