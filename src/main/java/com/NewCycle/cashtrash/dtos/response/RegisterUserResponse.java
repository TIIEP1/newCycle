package com.NewCycle.cashtrash.dtos.response;

import com.NewCycle.cashtrash.model.User;

public record RegisterUserResponse(String name, String email, String tipoCliente) {
    public static RegisterUserResponse from(User user){
        return new RegisterUserResponse(user.getName(), user.getEmail(), user.getType().name());
    }
}
