package com.example.practices.dto;

import com.example.practices.entity.BookEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientDTO {

    private String name;
    private String surname;
    private int age;
    private String genero;
    private List<BookEntity> listBooks;

}
