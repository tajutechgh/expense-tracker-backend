package com.tajutechgh.expensetracker.controller;

import com.tajutechgh.expensetracker.dto.UserDto;
import com.tajutechgh.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    //TODO: get a user by id
    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "userId") Integer id){

        UserDto userDto = userService.getUserById(id);

        return  new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //TODO: get user by email
    @GetMapping("/get")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email){

        UserDto userDto = userService.getUserByEmail(email);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //TODO: login user
    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestParam String email, @RequestParam String password){

        UserDto userDto = userService.getUserByEmail(email);

        //check if password match
        if (!password.equals(userDto.getPassword())){

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //TODO: register user
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){

        UserDto savedUser = userService.createUser(userDto.getName(), userDto.getEmail(), userDto.getPassword());

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
