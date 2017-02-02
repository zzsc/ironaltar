package pl.ironaltar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ironaltar.domain.User;

/**
 * Created by szzc on 30.01.17.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmail(String email);
}
