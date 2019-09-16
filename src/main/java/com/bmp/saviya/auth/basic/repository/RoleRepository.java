package com.bmp.saviya.auth.basic.repository;

import com.bmp.saviya.auth.basic.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
