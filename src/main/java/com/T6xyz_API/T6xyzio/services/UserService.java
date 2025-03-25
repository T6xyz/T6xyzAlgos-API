package com.T6xyz_API.T6xyzio.services;

import java.nio.CharBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.T6xyz_API.T6xyzio.exceptions.AppException;
import com.T6xyz_API.T6xyzio.mappers.UserMapper;
import com.T6xyz_API.T6xyzio.users.CredentialsDTO;
import com.T6xyz_API.T6xyzio.users.User;
import com.T6xyz_API.T6xyzio.users.UserDTO;
import com.T6xyz_API.T6xyzio.users.UserRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
}