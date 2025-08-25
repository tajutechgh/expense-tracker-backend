package com.tajutechgh.expensetracker.mapper;

import com.tajutechgh.expensetracker.dto.UserDto;
import com.tajutechgh.expensetracker.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }

    public static User mapToUser(UserDto userDto){

        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getCreatedAt()
        );
    }
}
