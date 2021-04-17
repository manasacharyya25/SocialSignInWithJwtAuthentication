package manas25.github.SSIwithJWT.entities;

import lombok.Builder;

@Builder
public class AuthResponse
{
  private int userId;
  private String jwtToken;
}
