package com.jun.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
}