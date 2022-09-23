package com.example.practices.service.Impl;

import com.example.practices.dto.AuthorDTO;
import com.example.practices.entity.AuthorEntity;
import com.example.practices.mapper.AuthorMapper;
import com.example.practices.repository.AuthorRepository;
import com.example.practices.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorMapper authorMapper;
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public AuthorDTO save(AuthorDTO dto) {
        AuthorEntity entity = authorMapper.dto2Entity(dto);
        AuthorEntity entitySave = authorRepository.save(entity);
        AuthorDTO dtoSave = authorMapper.entity2DTO(entitySave);
        return dtoSave;
    }

    @Override
    public List<AuthorDTO> getAll() {
        List<AuthorEntity> entityList = authorRepository.findAll();
        List<AuthorDTO> authorDTOList = authorMapper.entityList2DTOList(entityList);
        return authorDTOList;
    }
    @Override
    public AuthorDTO getById(Long id) {
        Optional<AuthorEntity> entity = authorRepository.findById(id);
        AuthorDTO dto = authorMapper.entity2DTO(entity.get());
        return dto;
    }
    @Override
    public AuthorDTO update(Long id, AuthorDTO dto) {
        Optional<AuthorEntity> entity = authorRepository.findById(id);
        if(!entity.isPresent()){
            System.out.println("Entidad no encontrada");
        }
        authorMapper.refreshValuesEntity(entity.get(), dto);
        AuthorEntity saveEntity = authorRepository.save(entity.get());
        AuthorDTO result = authorMapper.entity2DTO(saveEntity);
        return result;
    }


}
