package com.solitera.assignment.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
   @NotNull(message = "username not null")
   private String username;
   @NotNull(message = "password not null")
   private String password;

}
