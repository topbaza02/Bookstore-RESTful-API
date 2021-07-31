package com.example.scb.bookstore.model.dto.res;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDetailResponse {
    private String name;
    private String surname;
    private String dateOfBirth;
    private List<Integer> books = new ArrayList<>();
}
