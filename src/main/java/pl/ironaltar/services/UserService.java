package pl.ironaltar.services;

import pl.ironaltar.domain.User;

/**
 * Created by szzc on 30.01.17.
 */
public interface UserService {
    Iterable<User> listAllUsers();
    User findByUserName(String userName);
}
