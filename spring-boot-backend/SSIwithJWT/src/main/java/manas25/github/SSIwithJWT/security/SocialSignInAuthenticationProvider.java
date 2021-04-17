package manas25.github.SSIwithJWT.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SocialSignInAuthenticationProvider extends DaoAuthenticationProvider {
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            this.logger.debug("Failed to authenticate since no credentials provided");
            throw new BadCredentialsException(this.messages
                    .getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }

        //TODO: Replace with Auth Token Id Verification Logic. Throw Exception in case of Mismatch
//        String presentedPassword = authentication.getCredentials().toString();
//        if (!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
//            this.logger.debug("Failed to authenticate since password does not match stored value");
//            throw new BadCredentialsException(this.messages
//                    .getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
//        }
    }
}
