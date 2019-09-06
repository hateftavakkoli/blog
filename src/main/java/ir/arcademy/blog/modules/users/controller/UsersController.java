package ir.arcademy.blog.modules.users.controller;

import ir.arcademy.blog.modules.users.model.Users;
import ir.arcademy.blog.modules.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String users() {
        return "users/users";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String registerPage() {
        return "users/registerUser";
    }

    @RequestMapping(value = "/rest/getUsers" , method = RequestMethod.GET)
    public @ResponseBody
    List<Users> getUsers() {
        return usersService.findAllUsers();
    }

    @RequestMapping(value = "/rest/register", method = RequestMethod.POST)
    public @ResponseBody
    Users registerUser(@RequestBody Users users) {
        return usersService.registerUser(users);
    }


}
