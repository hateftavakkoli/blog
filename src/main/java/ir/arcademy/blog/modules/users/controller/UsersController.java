package ir.arcademy.blog.modules.users.controller;

import ir.arcademy.blog.modules.users.model.Users;
import ir.arcademy.blog.modules.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", usersService.findAllUsers());
        return "users/users";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new Users());
        return "users/registerUser";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String registerPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", usersService.findById(id));
        return "users/registerUser";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        usersService.deleteById(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute(name = "user") @Valid Users users, BindingResult bindingResult) throws IOException, InvocationTargetException, IllegalAccessException {
        if (bindingResult.hasErrors())
            return "users/registerUser";

        usersService.registerUser(users);
        return "redirect:/users";
    }

    @RequestMapping(value = "/rest/getUsers", method = RequestMethod.GET)
    public @ResponseBody
    List<Users> getUsers() {
        return usersService.findAllUsers();
    }

    @RequestMapping(value = "/rest/register", method = RequestMethod.POST)
    public @ResponseBody
    Users registerUser(@RequestBody Users users) throws IOException, InvocationTargetException, IllegalAccessException {
        return usersService.registerUser(users);
    }


}
