package com.marceloluiz.crudclient.dto;

import com.marceloluiz.crudclient.entities.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ClientDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birtDate;
    private Integer children;

    public ClientDTO(@NotNull Client client){
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birtDate = client.getBirtDate();
        children = client.getChildren();
    }
}
