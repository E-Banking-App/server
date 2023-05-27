package com.ensa.ebanking.DAO;

//import com.example.springboottest.models.UserEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.ensa.ebanking.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ensa.ebanking.Models.UserEntity;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
