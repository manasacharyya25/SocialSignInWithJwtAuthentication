package manas25.github.SSIwithJWT.security;

import lombok.SneakyThrows;
import manas25.github.SSIwithJWT.entities.GoogleTokenVerificationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

public class SocialSignInAuthenticationProvider extends DaoAuthenticationProvider {
    @SneakyThrows
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            this.logger.debug("Failed to authenticate since no credentials provided");
            throw new BadCredentialsException(this.messages
                    .getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }

        try {
            RestTemplate restTemplate =  new RestTemplate();
            String googleTokenVerificationUrl = "https://oauth2.googleapis.com/tokeninfo?id_token=";

            ResponseEntity<GoogleTokenVerificationResponse> response = restTemplate.getForEntity(googleTokenVerificationUrl+authentication.getCredentials(), GoogleTokenVerificationResponse.class);

            if(!response.getBody().email.equals(userDetails.getUsername())) {
                throw new BadCredentialsException("Bad Credentials");
            }

        } catch (Exception ex) {
            throw new BadCredentialsException("Bad Credentials");
        }

//        response.toString();

        //TODO: Replace with Auth Token Id Verification Logic. Throw Exception in case of Mismatch
//        String presentedPassword = authentication.getCredentials().toString();
//        if (!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
//            this.logger.debug("Failed to authenticate since password does not match stored value");
//            throw new BadCredentialsException(this.messages
//                    .getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
//        }
    }
}
