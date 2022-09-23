package com.example.practices.controller;

import com.example.practices.dto.ClientDTO;
import com.example.practices.entity.ClientEntity;
import com.example.practices.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
public class ClientController {

    @Autowired
    ClientService clientService;


    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO dto){
        ClientDTO dtoSave = clientService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoSave);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id){
        ClientDTO dto = clientService.getById(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll(){
        List<ClientDTO> dto = clientService.getAll();
        return ResponseEntity.ok(dto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, ClientDTO dto){
        ClientDTO dtoUpdate = clientService.update(id, dto);
        return ResponseEntity.ok().body(dtoUpdate);
    }





}
