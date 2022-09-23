package com.example.practices.controller;

import com.example.practices.dto.BookDTO;
import com.example.practices.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll(){
        List<BookDTO> listDto = bookService.getAll();
        return ResponseEntity.ok(listDto);
    }

    @PostMapping
    public ResponseEntity<BookDTO> save(@RequestBody BookDTO dto){
        BookDTO saveDto = bookService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveDto);

    }


}
