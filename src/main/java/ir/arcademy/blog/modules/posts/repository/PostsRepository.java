package ir.arcademy.blog.modules.posts.repository;

import ir.arcademy.blog.modules.posts.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
