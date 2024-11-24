package com.marceloluiz.crudclient.services;

import com.marceloluiz.crudclient.dto.ClientDTO;
import com.marceloluiz.crudclient.entities.Client;
import com.marceloluiz.crudclient.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        return repository.findAll(pageable).map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }
}
