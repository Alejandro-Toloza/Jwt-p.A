package com.example.practices.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class BookEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int page;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AuthorEntity> authors = new ArrayList<>();

}
