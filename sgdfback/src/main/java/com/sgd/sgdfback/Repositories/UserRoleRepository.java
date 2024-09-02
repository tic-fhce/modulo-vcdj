package com.sgd.sgdfback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.Models.User_Role;

@Repository
public interface UserRoleRepository extends JpaRepository<User_Role, Integer>{
    User_Role findFirstByUserId(Integer userId);
}
