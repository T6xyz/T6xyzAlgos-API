package com.T6xyz_API.T6xyzio.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.T6xyz_API.T6xyzio.users.RegisterDTO;
import com.T6xyz_API.T6xyzio.users.User;
import com.T6xyz_API.T6xyzio.users.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "token", ignore = true)
    UserDTO toUserDTO(User user);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "isPremium", ignore = true)
    @Mapping(target = "role", ignore = true)
    User registerToUser(RegisterDTO credentials);
}