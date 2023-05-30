package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByEmail(String email);

    ClientEntity save(ClientEntity client);

    ClientEntity findByFirstName(String firstname);


}