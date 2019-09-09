package ir.arcademy.blog.modules;

import ir.arcademy.blog.modules.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private PostsService postsService;

    @Autowired
    public MainController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = {"", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllPosts());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }
}
