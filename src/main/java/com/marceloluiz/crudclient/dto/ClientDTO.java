package com.marceloluiz.crudclient.dto;

import com.marceloluiz.crudclient.entities.Client;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ClientDTO {
    private Long id;

    @NotBlank(message = "Field is required")
    @Size(min = 3, max = 80, message = "Name must be between 3 and 80 characters")
    private String name;

    @NotBlank(message = "CPF is required")
    @Size(min = 11, max = 11, message = "CPF must contain exactly 11 characters")
    @Pattern(regexp = "\\d{11}", message = "CPF must contain only numeric characters")
    private String cpf;

    @Positive(message = "The price must be positive")
    private Double income;

    @NotNull
    @PastOrPresent(message = "Birth date cannot be in the future")
    private LocalDate birtDate;

    @Min(value = 0, message = "Number of children cannot be negative")
    private Integer children;

    public ClientDTO(@org.jetbrains.annotations.NotNull Client client){
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birtDate = client.getBirtDate();
        children = client.getChildren();
    }
}
