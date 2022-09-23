package com.example.practices.mapper;


import com.example.practices.dto.AuthorDTO;
import com.example.practices.entity.AuthorEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AuthorMapper {

    public AuthorDTO entity2DTO(AuthorEntity entity){
        AuthorDTO dto = new AuthorDTO();
        dto.setName(entity.getName());
        return dto;
    }

    public AuthorEntity dto2Entity(AuthorDTO dto){
        AuthorEntity entity = new AuthorEntity();
        entity.setName(dto.getName());
        return entity;
    }

    public Set<AuthorEntity> dtoList2EntityList(List<AuthorDTO> dtoList){
        Set<AuthorEntity> entityList = new HashSet<>();
        for(AuthorDTO dto : dtoList){
            entityList.add(dto2Entity(dto));
        }
        return entityList;
    }

    public List<AuthorDTO> entityList2DTOList(List<AuthorEntity> entityList){
        List<AuthorDTO> dtoList = new ArrayList<>();
        for(AuthorEntity entity: entityList){
            dtoList.add(entity2DTO(entity));
        }
        return dtoList;

    }

    public void refreshValuesEntity(AuthorEntity entity, AuthorDTO dto){
       entity.setName(dto.getName());
    }


}
