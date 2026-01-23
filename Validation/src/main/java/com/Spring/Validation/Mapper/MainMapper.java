package com.Spring.Validation.Mapper;

import com.Spring.Validation.DTO.MyDto;
import com.Spring.Validation.Enitity.MyEntity;
import org.springframework.stereotype.Component;

@Component
public class MainMapper {

    public MyEntity toEntity(MyDto dto){

        MyEntity entity = new MyEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    public MyDto toDto(MyEntity entity){

        MyDto dto = new MyDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        return dto;
    }


}
