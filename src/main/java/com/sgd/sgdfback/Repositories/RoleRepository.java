package com.sgd.sgdfback.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.Models.Role;
import com.sgd.sgdfback.Models.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByName(RoleName roleName);

    
}
