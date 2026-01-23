package com.Spring.Validation.Controller;

import com.Spring.Validation.DTO.MyDto;
import com.Spring.Validation.Enitity.MyEntity;
import com.Spring.Validation.Service.MyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/users")
    public ResponseEntity<List<MyDto>> getHello(){
        List<MyDto> entity = myService.findAll();
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PutMapping("email/{id}")
    public ResponseEntity<MyDto> updateEmail(@PathVariable int id,@Valid @RequestBody MyDto dto){
        MyDto user = myService.updateEmail(id,dto.getEmail());
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(
            @Valid @RequestBody List<MyDto> dto){
        myService.addUser(dto);
        return new ResponseEntity<>("Users Created",HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        myService.deleteUser(id);
        return new ResponseEntity<>("User Deleted",HttpStatus.ACCEPTED);
    }


}
