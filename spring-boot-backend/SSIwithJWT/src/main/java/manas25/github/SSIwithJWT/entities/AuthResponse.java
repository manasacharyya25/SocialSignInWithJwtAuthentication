package manas25.github.SSIwithJWT.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse
{
  private int userId;
  private String jwtToken;
}
