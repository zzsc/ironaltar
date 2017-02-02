package pl.ironaltar.services;

import pl.ironaltar.domain.User;

/**
 * Created by szzc on 30.01.17.
 */
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
