package com.T6xyz_API.T6xyzio.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDTO {
    private String username;
    private char[] password;
    private String email;
    private String profileURL;
    private Boolean isStudent;
    private Boolean agreedTerms;
}