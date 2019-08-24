package ir.arcademy.blog.modules;

import ir.arcademy.blog.modules.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

}
