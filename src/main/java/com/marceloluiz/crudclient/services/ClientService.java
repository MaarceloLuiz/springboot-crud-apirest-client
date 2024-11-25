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

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        copyDtoToEntity(client, dto);

        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        Client client = repository.getReferenceById(id);
        copyDtoToEntity(client, dto);

        return new ClientDTO(client);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    private void copyDtoToEntity(Client entity, ClientDTO dto) {
        entity.setName(dto.getName() != null ? dto.getName() : entity.getName());
        entity.setCpf(dto.getCpf() != null ? dto.getCpf() : entity.getCpf());
        entity.setBirtDate(dto.getBirtDate() != null ? dto.getBirtDate() : entity.getBirtDate());
        entity.setChildren(dto.getChildren() != null ? dto.getChildren() : entity.getChildren());

    }
}
