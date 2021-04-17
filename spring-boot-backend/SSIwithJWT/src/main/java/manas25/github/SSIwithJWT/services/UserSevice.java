package manas25.github.SSIwithJWT.services;

import manas25.github.SSIwithJWT.AppUtils;
import manas25.github.SSIwithJWT.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSevice implements UserDetailsService {
    @Autowired
    private UsersRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        int userId = AppUtils.getHashId(username);
        return userRepo.findById(userId).get();
    }
}
