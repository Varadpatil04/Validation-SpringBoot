package com.Spring.Validation.Service;

import com.Spring.Validation.DTO.MyDto;
import com.Spring.Validation.Enitity.MyEntity;
import com.Spring.Validation.Mapper.MainMapper;
import com.Spring.Validation.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyService {

    @Autowired
    private Repo repo;
    @Autowired
    private MainMapper mainMapper;


    public void addUser(List<MyDto> dto) {

        dto.stream().map(x -> mainMapper.toEntity(x)).forEach(x -> repo.save(x));

//        MyEntity entity = mainMapper.toEntity(dto);
//        repo.save(entity);
    }

    public List<MyDto> findAll() {

        List<MyDto> entity = repo.findAll()
                .stream()
                .map(X -> mainMapper.toDto(X))
                .toList();

        return entity;

    }
    public MyDto updateEmail(int id, String email) {
        MyEntity entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found" + id));
        entity.setEmail(email);
        repo.save(entity);
        return mainMapper.toDto(entity);
    }


    public void deleteUser(int id) {
        repo.deleteById(id);
    }


    public class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(String message){
            super(message);
        }
    }
}
