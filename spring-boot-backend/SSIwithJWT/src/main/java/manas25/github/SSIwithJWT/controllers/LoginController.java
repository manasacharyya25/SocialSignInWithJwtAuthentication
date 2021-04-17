package manas25.github.SSIwithJWT.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import manas25.github.SSIwithJWT.AppUtils;
import manas25.github.SSIwithJWT.entities.AuthResponse;
import manas25.github.SSIwithJWT.entities.Users;
import manas25.github.SSIwithJWT.repositories.UsersRepository;
import manas25.github.SSIwithJWT.security.SocialSignInAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class LoginController
{
  @Autowired
  private UsersRepository usersRepo;

  @Autowired
  private SocialSignInAuthenticationManager authManager;

  @GetMapping()
  public String GetUserById() {
    return "Authenticated";
  }

  @PostMapping("signup")
  public String SignUpUser(@RequestBody Users user) {
    try {
      authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

      int userId = AppUtils.getHashId(user.getEmail());
      Optional<Users> existingUser = usersRepo.findById(userId);

      if(!existingUser.isPresent()) {
        user.setId(userId);
        Users newUser = usersRepo.saveAndFlush(user);
      }

      final String secretKey = "SECretSeccrettSescertaskshdfas42343rtyerty4565ethet7567845utyjtyu84578rtyui4ru4567SECretSeccrettSescertaskshdfas";

      final String jwtToken = Jwts.builder()
          .setSubject(user.getEmail())
          .claim("authorities", user.getAuthorities())
          .setIssuedAt(new Date())
          .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
          .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
          .compact();

      return jwtToken;

//      return AuthResponse.builder()
//          .userId(userId)
//          .jwtToken(jwtToken)
//          .build();
    }catch (Exception ex) {
      throw new RuntimeException("User Authentication Failed");
    }
  }
}
