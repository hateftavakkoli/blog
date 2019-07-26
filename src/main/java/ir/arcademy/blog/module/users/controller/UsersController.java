package ir.arcademy.blog.module.users.controller;

import ir.arcademy.blog.module.users.model.Users;
import ir.arcademy.blog.module.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/newUser")
    public Users insert(@RequestBody Users users) {
        return usersService.registerUser(users);
    }

    @RequestMapping("/getUsers")
    public List<Users> getUsers() {
        return usersService.getUsers();
    }
}
