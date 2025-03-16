package com.T6xyz_API.T6xyzio.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser() {
        UserDTO testUser = new UserDTO("test", "test", "test", false, false, false);
        userRepo.save(testUser);
        return ResponseEntity.ok("Response");
    }
}