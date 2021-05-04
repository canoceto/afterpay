package com.clearpay.demo.security;

public class UnauthorizedUserRoleException extends RuntimeException {

    public UnauthorizedUserRoleException() {
        super("The user doesn't have permission for this request");
    }
}
