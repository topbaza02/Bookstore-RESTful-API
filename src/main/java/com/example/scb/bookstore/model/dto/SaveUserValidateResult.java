package com.example.scb.bookstore.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SaveUserValidateResult {
    @JsonIgnore
    private boolean pass = true;
    private String message;
}
