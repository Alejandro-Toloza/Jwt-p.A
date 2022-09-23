package com.example.practices.service;

import com.example.practices.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO save(ClientDTO dto);
    ClientDTO getById(Long id);
    List<ClientDTO> getAll();
    ClientDTO update(Long id, ClientDTO dto);
}
