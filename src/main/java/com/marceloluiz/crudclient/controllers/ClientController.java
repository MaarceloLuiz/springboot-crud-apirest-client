package com.marceloluiz.crudclient.controllers;

import com.marceloluiz.crudclient.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
@RequiredArgsConstructor
public class ClientController {
    private ClientService service;
}
