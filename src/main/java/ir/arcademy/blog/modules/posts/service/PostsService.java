package ir.arcademy.blog.modules.posts.service;

import ir.arcademy.blog.modules.posts.model.Category;
import ir.arcademy.blog.modules.posts.model.Posts;
import ir.arcademy.blog.modules.posts.repository.PostsRepository;
import ir.arcademy.blog.modules.users.model.Users;
import ir.arcademy.blog.modules.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Transactional
    public Posts registerPost(Posts posts) {
        return this.postsRepository.save(posts);
    }

    public List<Posts> findAllPosts() {
        return this.postsRepository.findAll();
    }


}
