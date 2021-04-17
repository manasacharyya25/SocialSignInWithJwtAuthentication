package manas25.github.SSIwithJWT.controllers;

import manas25.github.SSIwithJWT.AppUtils;
import manas25.github.SSIwithJWT.entities.Users;
import manas25.github.SSIwithJWT.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class LoginController
{
  @Autowired
  private UsersRepository usersRepo;

  @GetMapping()
  public String GetUserById() {
    return "Authenticated";
  }

  @PostMapping("signup")
  public int SignUpUser(@RequestBody Users user) {
    int userId = AppUtils.getHashId(user.getUsername());
    Optional<Users> existingUser = usersRepo.findById(userId);

    if(!existingUser.isPresent()) {
      user.setId(userId);
      Users newUser = usersRepo.saveAndFlush(user);
      return newUser.getId();
    }
    return userId;
  }
}
