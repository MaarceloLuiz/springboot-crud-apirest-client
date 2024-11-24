package com.marceloluiz.crudclient.services;

import com.marceloluiz.crudclient.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private ClientRepository repository;
}
