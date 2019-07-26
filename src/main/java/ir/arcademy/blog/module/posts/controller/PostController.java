package ir.arcademy.blog.module.posts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.arcademy.blog.module.posts.model.Posts;
import ir.arcademy.blog.module.posts.repository.CategoryRepository;
import ir.arcademy.blog.module.posts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/newPost")
    public Posts newPost(@RequestBody Posts posts) {
        return postService.registerPost(posts);
    }

    @RequestMapping("/getPosts")
    public List<Posts> getPosts() {
        return postService.findAll();
    }


}
