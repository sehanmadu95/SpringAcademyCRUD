package com.example.demo.service;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<ResponseDTO> saveUser(UserDTO userDTO);

    public ResponseEntity<ResponseDTO>getUser(int id);

    public ResponseEntity<ResponseDTO>updateUser(UserDTO userDTO,int id);

    public ResponseEntity<ResponseDTO>deletUser(int id);

    public ResponseEntity<ResponseDTO>getAll();
}
