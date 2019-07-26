package ir.arcademy.blog.module.users.service;

import ir.arcademy.blog.module.users.model.Users;
import ir.arcademy.blog.module.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @Transactional
    public Users registerUser(Users users) {
       return usersRepository.save(users);
    }
}
