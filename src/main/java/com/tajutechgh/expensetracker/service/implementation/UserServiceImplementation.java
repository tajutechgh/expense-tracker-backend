package com.tajutechgh.expensetracker.service.implementation;

import com.tajutechgh.expensetracker.dto.UserDto;
import com.tajutechgh.expensetracker.entity.User;
import com.tajutechgh.expensetracker.exception.UserNotFoundException;
import com.tajutechgh.expensetracker.mapper.UserMapper;
import com.tajutechgh.expensetracker.repository.UserRepository;
import com.tajutechgh.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class UserServiceImplementation implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImplementation.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto getUserById(int userId) {

        logger.info("Getting the user by ID: " + userId);

        User user = userRepository.findById(userId).orElseThrow(

                () -> new UserNotFoundException("User with id " + userId + " not found")
        );

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {

        logger.info("Getting user by email: " + email);

        User user = userRepository.findByEmail(email);

        if (user == null){

            throw new UserNotFoundException("User with email " + email + " not found");
        }

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto createUser(String name, String username, String password) {

        User user = new User();

        user.setName(name);
        user.setEmail(username);
        user.setPassword(password);
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }
}
