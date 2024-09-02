package com.sgd.sgdfback.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByUsername(String username);

    @Query("SELECT COUNT(u) FROM User u WHERE u.cif LIKE :cod%")
    int countByCif(String cod);

}
