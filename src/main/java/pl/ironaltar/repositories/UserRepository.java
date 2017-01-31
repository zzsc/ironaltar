package pl.ironaltar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ironaltar.domain.User;

/**
 * Created by szzc on 30.01.17.
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUserName(String userName);
}
