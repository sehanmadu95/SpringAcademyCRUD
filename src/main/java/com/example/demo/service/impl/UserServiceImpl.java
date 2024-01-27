package com.example.demo.service.impl;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<ResponseDTO> saveUser(UserDTO userDTO) {

        try{

            User user=new User();
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            userRepository.save(user);
            log.info("Save user...");
            return new ResponseEntity<>(ResponseDTO
                    .builder().data(user)
                    .message("Data saving successfully").build(), HttpStatus.CREATED);


        }catch (Exception e) {
            log.error("Error while saving user....");

            return new ResponseEntity<>(ResponseDTO
                    .builder().data(null)
                    .message("Error while data saving...").build(), HttpStatus.BAD_REQUEST);

        }


    }

    @Override
    public ResponseEntity<ResponseDTO> getUser(int id) {

        try{

            Optional<User> user= userRepository.findById(id);
            return new ResponseEntity<>(ResponseDTO
                    .builder().data(user)
                    .message("Data Fetching successfully").build(), HttpStatus.OK);



        }catch (Exception e){
            log.error("Error while Data fetching....");
            return new ResponseEntity<>(ResponseDTO
                    .builder().data(null)
                    .message("Error while data fetching...").build(), HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<ResponseDTO> updateUser(UserDTO userDTO,int id) {
        try{

            User user= userRepository.findById(id).orElse(null);

            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());

            userRepository.save(user);


            return new ResponseEntity<>(ResponseDTO
                    .builder().data(user)
                    .message("Data updating successfully").build(), HttpStatus.OK);



        }catch (Exception e){
            log.error("Error while Data fetching....");
            return new ResponseEntity<>(ResponseDTO
                    .builder().data(null)
                    .message("Error while data updating...").build(), HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public ResponseEntity<ResponseDTO> deletUser(int id) {
        try{

            User user= userRepository.findById(id).orElse(null);

            userRepository.deleteById(id);
            return new ResponseEntity<>(ResponseDTO
                    .builder().data(user)
                    .message("Data Deleted successfully...").build(), HttpStatus.OK);



        }catch (Exception e){
            log.error("Error while Data Deleting....");
            return new ResponseEntity<>(ResponseDTO
                    .builder().data(null)
                    .message("Error while data Deleting...").build(), HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public ResponseEntity<ResponseDTO> getAll() {
        try{

           List<User>userList=userRepository.findAll();


            return new ResponseEntity<>(ResponseDTO
                    .builder().data(userList)
                    .message("Data Fetching successfully...").build(), HttpStatus.OK);



        }catch (Exception e){
            log.error("Error while Data Fetching....");
            return new ResponseEntity<>(ResponseDTO
                    .builder().data(null)
                    .message("Error while data Fetching...").build(), HttpStatus.BAD_REQUEST);

        }
    }
}
