package com.T6xyz_API.T6xyzio.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.T6xyz_API.T6xyzio.users.User;
import com.T6xyz_API.T6xyzio.users.UserDTO;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
}