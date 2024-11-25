package com.marceloluiz.crudclient.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@SuperBuilder
@Getter
public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
