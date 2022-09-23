package com.example.practices.service;


import com.example.practices.dto.BookDTO;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    BookDTO save(BookDTO dto);
    List<BookDTO> getAll();
    BookDTO getById(Long id);
}
