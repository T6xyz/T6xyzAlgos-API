package com.T6xyz_API.T6xyzio.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority{
    USER,
    PREMIUM;

    @Override
    public String getAuthority() {
        return this.name();
    }
}