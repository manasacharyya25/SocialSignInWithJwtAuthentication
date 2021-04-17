package manas25.github.SSIwithJWT.repositories;

import manas25.github.SSIwithJWT.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>
{
}