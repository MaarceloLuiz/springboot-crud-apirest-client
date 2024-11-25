package com.marceloluiz.crudclient.services;

import com.marceloluiz.crudclient.dto.ClientDTO;
import com.marceloluiz.crudclient.entities.Client;
import com.marceloluiz.crudclient.repositories.ClientRepository;
import com.marceloluiz.crudclient.services.exceptions.DatabaseException;
import com.marceloluiz.crudclient.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource Not Found"));
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
        try{
            Client client = repository.getReferenceById(id);
            copyDtoToEntity(client, dto);

            return new ClientDTO(client);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource Not Found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)) throw new ResourceNotFoundException("Resource Not Found");

        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Referential Integrity Failure");
        }
    }

    private void copyDtoToEntity(Client entity, ClientDTO dto) {
        entity.setName(dto.getName() != null ? dto.getName() : entity.getName());
        entity.setCpf(dto.getCpf() != null ? dto.getCpf() : entity.getCpf());
        entity.setBirtDate(dto.getBirtDate() != null ? dto.getBirtDate() : entity.getBirtDate());
        entity.setChildren(dto.getChildren() != null ? dto.getChildren() : entity.getChildren());

    }
}
