package com.T6xyz_API.T6xyzio.users;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.T6xyz_API.T6xyzio.config.UserAuthProvider;
import com.T6xyz_API.T6xyzio.exceptions.AppException;
import com.T6xyz_API.T6xyzio.services.UserService;

import lombok.RequiredArgsConstructor;
 
@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> authUser(@RequestBody CredentialsDTO userCredentials) throws AppException {
        UserDTO user = userService.login(userCredentials);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterDTO registerCredentials) throws AppException {
        UserDTO user = userService.register(registerCredentials);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.created(URI.create("/users/" + user.getUsername())).body(user);
    }

    @GetMapping("/home")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatusCode getLectures() {
        return HttpStatus.OK;
    }

    @GetMapping("/ds")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatusCode getDataStructures() {
        return HttpStatus.OK;
    }

    @GetMapping("/a")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatusCode getAlgorithms() {
        return HttpStatus.OK;
    }

    @GetMapping("/dp")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatusCode getDPLectures() {
        return HttpStatus.OK;
    }
}