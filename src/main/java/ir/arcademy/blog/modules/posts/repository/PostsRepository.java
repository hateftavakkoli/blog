package ir.arcademy.blog.modules.posts.repository;

import ir.arcademy.blog.modules.posts.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {


    //    @Query("select p from Posts p where :#{#posts.title} is null or p.title like concat('%',:#{#posts.title},'%')")
    @Query("select p from Posts p join p.categories pc where (:#{#posts.title} is null or " +
            "p.title like concat('%',:#{#posts.title},'%')) and " +
            "(coalesce(:#{#posts.categories},null) is null or " +
            "pc in (:#{#posts.categories})) " +
            "group by p.id having count (p.id) >= :num")
    Page<Posts> findBySearch(Posts posts, @Param("num") Long size, Pageable pageable);

}
