package com.marceloluiz.crudclient.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    @Column(name = "birth_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate birtDate;
    private Integer children;

}
