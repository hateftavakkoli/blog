package ir.arcademy.blog.modules.users.repository;

import ir.arcademy.blog.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users,Long> {

    // select * from users where email="..."

    Users findByEmail(String email);

    @Query("select u from Users u where u.email = :email")
    Users userEmail(@Param("email") String email);

}
