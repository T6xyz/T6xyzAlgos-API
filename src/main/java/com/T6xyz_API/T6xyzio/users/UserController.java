package com.T6xyz_API.T6xyzio.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getCSRF")
    public CsrfToken getCSRF(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser() {
        UserDTO testUser = new UserDTO("Da weed", "test", "test", false, false, false);
        userRepo.save(testUser);
        return ResponseEntity.ok("Response");
    }
}