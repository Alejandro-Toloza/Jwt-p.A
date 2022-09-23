package com.example.practices.service.Impl;

import com.example.practices.dto.BookDTO;
import com.example.practices.entity.BookEntity;
import com.example.practices.mapper.BookMapper;
import com.example.practices.repository.BookRepository;
import com.example.practices.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper authorMapper;
    @Autowired
    BookRepository bookRepository;


    @Override
    public BookDTO save(BookDTO dto) {
        BookEntity entity = authorMapper.bookDTO2Entity(dto);
        BookEntity saveEntity = bookRepository.save(entity);
        BookDTO saveDTO = authorMapper.bookEntity2DTO(saveEntity);
        return saveDTO;
    }

    @Override
    public List<BookDTO> getAll() {
        List<BookEntity> entityList = bookRepository.findAll();
        List<BookDTO> dtoList = authorMapper.BookEntitListy2DTO(entityList);
        return dtoList;
    }

    @Override
    public BookDTO getById(Long id) {
        return null;
    }
}
