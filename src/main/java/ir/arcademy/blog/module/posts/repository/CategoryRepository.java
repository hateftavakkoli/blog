package ir.arcademy.blog.module.posts.repository;

import ir.arcademy.blog.module.posts.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
