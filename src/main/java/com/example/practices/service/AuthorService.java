package com.example.practices.service;

import com.example.practices.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorDTO save(AuthorDTO dto);
    List<AuthorDTO> getAll();
    AuthorDTO getById(Long id);
    AuthorDTO update(Long id, AuthorDTO dto);

}
