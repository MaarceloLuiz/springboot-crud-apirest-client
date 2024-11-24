package com.marceloluiz.crudclient.controllers;

import com.marceloluiz.crudclient.dto.ClientDTO;
import com.marceloluiz.crudclient.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

}
