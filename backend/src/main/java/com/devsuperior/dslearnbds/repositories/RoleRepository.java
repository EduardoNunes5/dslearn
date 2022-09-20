package com.devsuperior.dslearnbds.repositories;

import com.devsuperior.dslearnbds.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
