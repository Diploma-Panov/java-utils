package com.mpanov.diploma.data;

public enum UserSystemRole {
    USER,
    ADMIN;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
