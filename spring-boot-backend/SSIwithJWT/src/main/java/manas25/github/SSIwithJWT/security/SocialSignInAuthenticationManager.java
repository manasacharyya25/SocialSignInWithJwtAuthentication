package manas25.github.SSIwithJWT.security;

import lombok.val;
import manas25.github.SSIwithJWT.entities.GoogleTokenVerificationResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SocialSignInAuthenticationManager implements AuthenticationManager
{
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException
  {
    try {
      RestTemplate restTemplate = new RestTemplate();
      String googleTokenVerificationUrl = "https://oauth2.googleapis.com/tokeninfo?id_token=";

      ResponseEntity<GoogleTokenVerificationResponse> response =
          restTemplate.getForEntity(googleTokenVerificationUrl + authentication.getCredentials(), GoogleTokenVerificationResponse.class);

      if(response.getBody().email.equals(authentication.getPrincipal())) {
//        val successAuthenticationToken = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(),
//            authentication.getAuthorities());
//        authentication.setAuthenticated(true);
        return authentication;
      } else {
        throw new BadCredentialsException("Bad Credentials");
      }
    } catch (Exception ex) {
      throw new BadCredentialsException("Bad Credentials");
    }
  }
}
