package com.marceloluiz.crudclient.repositories;

import com.marceloluiz.crudclient.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
