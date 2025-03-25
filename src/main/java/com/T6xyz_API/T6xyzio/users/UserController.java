package com.T6xyz_API.T6xyzio.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.T6xyz_API.T6xyzio.exceptions.AppException;
import com.T6xyz_API.T6xyzio.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<UserDTO> authUser(@RequestBody CredentialsDTO userCredentials) throws AppException {
        UserDTO user = userService.login(userCredentials);
        return ResponseEntity.ok(user);
    }
}