package com.example.scb.bookstore.model.dao;

import com.example.scb.bookstore.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
public class User {
    @Id
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String name;
    private String surname;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DD_MM_YYYY)
    private Date dateOfBirth;

    public User(@NotBlank String username, @NotBlank String password, String name, String surname, @NotNull Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
}