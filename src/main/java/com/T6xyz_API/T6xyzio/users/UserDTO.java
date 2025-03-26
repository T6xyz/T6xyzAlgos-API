package com.T6xyz_API.T6xyzio.users;

import com.T6xyz_API.T6xyzio.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String token;
    private Boolean isPremium;
    private Roles role;
}