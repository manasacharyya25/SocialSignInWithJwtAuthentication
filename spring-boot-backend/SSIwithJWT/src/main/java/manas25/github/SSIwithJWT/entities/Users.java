package manas25.github.SSIwithJWT.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Users
{
  @Id
  @GeneratedValue
  private int id;
  private String username;
  private String email;
  private String photoUrl;
}
