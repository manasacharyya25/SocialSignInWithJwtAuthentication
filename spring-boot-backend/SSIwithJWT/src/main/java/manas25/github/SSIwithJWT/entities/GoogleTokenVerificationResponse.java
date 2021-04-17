package manas25.github.SSIwithJWT.entities;

import lombok.Data;

@Data
public class GoogleTokenVerificationResponse
{
  public String iss;
  public String azp;
  public String aud;
  public String sub;
  public String email;
  public String name;
  public String picture;
  public String given_name;
  public String family_name;
}
