package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.AgentEntity;
import com.ensa.ebanking.Models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientDAO extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByEmail(String email);
    Optional<ClientEntity> findById(Long id);

    ClientEntity save(ClientEntity client);

    ClientEntity findByUsername(String Username);


}