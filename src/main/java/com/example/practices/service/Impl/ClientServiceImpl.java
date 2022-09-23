package com.example.practices.service.Impl;

import com.example.practices.dto.ClientDTO;
import com.example.practices.entity.ClientEntity;
import com.example.practices.mapper.ClientMapper;
import com.example.practices.repository.ClientRepository;
import com.example.practices.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientMapper clientMapper;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDTO save(ClientDTO dto) {
        ClientEntity entity = clientMapper.clientDTO2Entity(dto);
        ClientEntity entitySave = clientRepository.save(entity);
        ClientDTO result = clientMapper.clientEntity2DTO(entitySave);
        return result;
    }

    @Override
    public ClientDTO getById(Long id) {
        Optional<ClientEntity> entity = clientRepository.findById(id);
        if(!entity.isPresent()){
            System.out.println("Id no encontrado");
        }
        ClientDTO entitySave= clientMapper.clientEntity2DTO(entity.get());
        return entitySave;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<ClientEntity> entity = clientRepository.findAll();
        List<ClientDTO> dtos = clientMapper.listEntity2DTOList(entity);
        return dtos;
    }

    @Override
    public ClientDTO update(Long id, ClientDTO dto) {
        Optional<ClientEntity> entity = clientRepository.findById(id);
        if(!entity.isPresent()){
            System.out.println("Id no encontrado");
        }
        clientMapper.refreshValues(dto, entity.get());
        ClientEntity entitySave = clientRepository.save(entity.get());
        ClientDTO result = clientMapper.clientEntity2DTO(entitySave);
        return result;

    }


}
