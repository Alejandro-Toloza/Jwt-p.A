package com.example.practices.dto;

import com.example.practices.entity.AuthorEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDTO {

    private String name;
    private int page;
    private List<AuthorEntity> authors;

}
