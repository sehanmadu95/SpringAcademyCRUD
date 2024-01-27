package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //origine dekaka(front or backend wala data share karaganna
@RequestMapping("api/v1/user")//Request map karanawa URL through
@RestController//responsebody+controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable int id){
       return userService.getUser(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable int id){
        return userService.updateUser(userDTO,id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO>deletUser(@PathVariable int id){
        return userService.deletUser(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO>getAll(){
        return userService.getAll();
    }
}
