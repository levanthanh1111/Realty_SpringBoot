package com.example.land.controller;


import com.example.land.dto.UserDTO;
import com.example.land.entity.User;
import com.example.land.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserDTO> getAll(){
        return userService.getAll().stream().map(user -> modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id){
        User user = userService.getUser(id);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        User userRequest = modelMapper.map(userDTO,User.class);
        User user = userService.createUser(userRequest);
        UserDTO userReponse = modelMapper.map(user,UserDTO.class);

        return new ResponseEntity<UserDTO>(userReponse,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable("id") Long id){
        User userRequest = modelMapper.map(userDTO, User.class);
        User user = userService.updateUser(userRequest,id);
        UserDTO userResponse = modelMapper.map(user, UserDTO.class);
        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
