package ir.arcademy.blog.module.posts.repository;

import ir.arcademy.blog.module.posts.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts,Long> {

}
