package com.T6xyz_API.T6xyzio.services;

import java.nio.CharBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.T6xyz_API.T6xyzio.enums.Roles;
import com.T6xyz_API.T6xyzio.exceptions.AppException;
import com.T6xyz_API.T6xyzio.mappers.UserMapper;
import com.T6xyz_API.T6xyzio.users.CredentialsDTO;
import com.T6xyz_API.T6xyzio.users.RegisterDTO;
import com.T6xyz_API.T6xyzio.users.User;
import com.T6xyz_API.T6xyzio.users.UserDTO;
import com.T6xyz_API.T6xyzio.users.UserRepo;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public UserDTO login(CredentialsDTO credentials) throws AppException {
        // Check if username exists in the Users cluster
        User user = userRepo.findByUsername(credentials.getUsername());

        // Check if user is not found
        if (user == null) {
            throw new AppException("User was not found!", HttpStatus.NOT_FOUND);
        }

        // Valdiate password
        if (passwordEncoder.matches(CharBuffer.wrap(credentials.getPassword()), user.getPassword())) {
            return userMapper.toUserDTO(user);
        } else {
            throw new AppException("Password is incorrect!", HttpStatus.BAD_REQUEST);
        }
    }

    public UserDTO register(RegisterDTO credentials) {

        User foundUser = userRepo.findByUsername(credentials.getUsername());

        // Check if user exists
        if (foundUser != null) {
            throw new AppException("Username already exists!", HttpStatus.BAD_REQUEST);
        }
        // Create new user
        User user = userMapper.registerToUser(credentials);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(credentials.getPassword())));
        user.setRole(Roles.USER);
        User savedUser = userRepo.save(user);
        return userMapper.toUserDTO(savedUser);
    }
}