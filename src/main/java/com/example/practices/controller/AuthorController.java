package com.example.practices.controller;

import com.example.practices.dto.AuthorDTO;
import com.example.practices.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDTO> save(@RequestBody AuthorDTO dto){
        AuthorDTO dtoSave = authorService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoSave);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAll(){
        List<AuthorDTO> listAuthor =  authorService.getAll();
        return ResponseEntity.ok(listAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getById(@PathVariable Long id){
        AuthorDTO dto = authorService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable Long id, @RequestBody AuthorDTO dto){
            AuthorDTO result = authorService.update(id, dto);
            return ResponseEntity.ok().body(result);
    }


}
