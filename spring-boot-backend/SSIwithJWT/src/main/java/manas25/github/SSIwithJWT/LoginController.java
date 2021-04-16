package manas25.github.SSIwithJWT;

import lombok.val;
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

  @GetMapping("{id}")
  public Optional<Users> GetUserById(@PathVariable int id) {
    return usersRepo.findById(id);
  }

  @PostMapping("signup")
  public int SignUpUser(@RequestBody Users user) {
    Optional<Users> existingUser = usersRepo.findById(user.getId());

    if(!existingUser.isPresent()) {
      Users newUser = usersRepo.saveAndFlush(user);
      return newUser.getId();
    }
    return existingUser.get().getId();
  }
}
