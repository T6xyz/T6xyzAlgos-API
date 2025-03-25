package com.T6xyz_API.T6xyzio.users;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
public class User {
    private String username;
    private String password;
    private String email;
    private String profileURL;
    private Boolean isStudent;
    private Boolean isPremium;
    private Boolean agreedTerms;
}