package pl.ironaltar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ironaltar.services.UserService;

/**
 * Created by szzc on 30.01.17.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users",userService.listAllUsers());
        return "users";
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public String list(@PathVariable String userName, Model model){
        model.addAttribute("user", userService.findByUserName(userName));
        return "user";
    }


}
