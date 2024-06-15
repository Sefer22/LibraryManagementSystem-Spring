package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
