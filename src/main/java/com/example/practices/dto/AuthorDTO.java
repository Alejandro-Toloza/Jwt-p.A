package com.example.practices.dto;

import com.example.practices.entity.BookEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDTO {

    private String name;
    private List<BookEntity> books;
}
