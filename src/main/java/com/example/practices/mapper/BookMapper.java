package com.example.practices.mapper;

import com.example.practices.dto.BookDTO;
import com.example.practices.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookMapper {

    public BookDTO bookEntity2DTO(BookEntity entity){
        BookDTO dto = new BookDTO();
        dto.setName(entity.getName());
        dto.setPage(entity.getPage());
        return dto;
    }


    public BookEntity bookDTO2Entity(BookDTO dto){
        BookEntity entity = new BookEntity();
        entity.setName(dto.getName());
        entity.setPage(dto.getPage());
        return entity;
    }


    public Set<BookEntity> BookDTOList2Entity(List<BookDTO> dtosList){
        Set<BookEntity> entityList = new HashSet<>();
        for(BookDTO dto: dtosList){
            entityList.add(bookDTO2Entity(dto));
        }
        return entityList;
    }


    public List<BookDTO> BookEntitListy2DTO(List<BookEntity> entityList){
        List<BookDTO> dtoList = new ArrayList<>();
        for(BookEntity entity: entityList){
            dtoList.add(bookEntity2DTO(entity));
        }
        return dtoList;
    }



}
