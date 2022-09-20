package com.devsuperior.dslearnbds.repositories;

import com.devsuperior.dslearnbds.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
