package repos;

import entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by User on 9/12/2018.
 */
public interface UsersRepo extends JpaRepository<Users, Integer>
{
    List<Users> findAllUsers();
}
