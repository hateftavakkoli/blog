package ir.arcademy.blog.module.users.repository;

import ir.arcademy.blog.module.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);

    @Query("select u from Users u where u.email = :email")
    Users findByQuery(@Param("email") String email);


}
