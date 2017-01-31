package pl.ironaltar.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ironaltar.domain.User;
import pl.ironaltar.repositories.UserRepository;

/**
 * Created by szzc on 30.01.17.
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> listAllUsers() {return userRepository.findAll();}
    @Override
    public User findByUserName(String userName){return userRepository.findByUserName(userName);}
}
