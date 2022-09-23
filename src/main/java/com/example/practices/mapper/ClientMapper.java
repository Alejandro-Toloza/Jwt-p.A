package com.example.practices.mapper;

import com.example.practices.dto.ClientDTO;
import com.example.practices.entity.ClientEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public ClientEntity clientDTO2Entity(ClientDTO dto){
        ClientEntity entity = new ClientEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setGenero(dto.getGenero());
        return entity;
    }

    public ClientDTO clientEntity2DTO(ClientEntity entity){
        ClientDTO dto = new ClientDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setGenero(entity.getGenero());
        return dto;
    }

    public List<ClientDTO> listEntity2DTOList(List<ClientEntity> listEntity){
        List<ClientDTO> listDTO = new ArrayList<>();
        for(ClientEntity entity : listEntity){
            listDTO.add(clientEntity2DTO(entity));
        }
        return listDTO;
    }


    public void refreshValues(ClientDTO dtoR, ClientEntity entityR){
        entityR.setName(dtoR.getName());
        entityR.setSurname(dtoR.getSurname());
        entityR.setAge(dtoR.getAge());
        entityR.setGenero(dtoR.getGenero());
    }



}
