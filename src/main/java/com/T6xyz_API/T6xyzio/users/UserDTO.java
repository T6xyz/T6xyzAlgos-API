package com.T6xyz_API.T6xyzio.users;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "Users")
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private Boolean isStudent;
    private Boolean isPremium;
    private Boolean agreedTerms;

    public UserDTO() {
        this(null, null, null, false, false, false);
    }

    public UserDTO(String username, String password, String email, 
    Boolean isStudent, Boolean isPremium, Boolean agreedTerms) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isStudent = isStudent;
        this.isPremium = isPremium;
        this.agreedTerms = agreedTerms;
    }
}