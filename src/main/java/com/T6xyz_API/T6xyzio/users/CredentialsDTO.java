package com.T6xyz_API.T6xyzio.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsDTO {
    private String username;
    private char[] password;

    public CredentialsDTO(String username, String password) {
        this(username, password.toCharArray());
    }

}
