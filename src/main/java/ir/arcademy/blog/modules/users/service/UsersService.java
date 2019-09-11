package ir.arcademy.blog.modules.users.service;

import ir.arcademy.blog.MyBeanCopy;
import ir.arcademy.blog.modules.users.model.Users;
import ir.arcademy.blog.modules.users.repository.UsersRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public Users registerUser(Users users) throws IOException, InvocationTargetException, IllegalAccessException {
        if (!users.getFile().isEmpty()) {
            String path = ResourceUtils.getFile("classpath:static/img").getAbsolutePath();
            byte[] bytes = users.getFile().getBytes();
            String name = UUID.randomUUID() + "." + Objects.requireNonNull(users.getFile().getContentType()).split("/")[1];
            Files.write(Paths.get(path + File.separator + name), bytes);
            users.setCover(name);
        }

        if (!users.getPassword().isEmpty())
            users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));

        if(users.getId() != null) {
            Users exist = usersRepository.getOne(users.getId());
            MyBeanCopy myBeanCopy = new MyBeanCopy();
            myBeanCopy.copyProperties(exist,users);
            return usersRepository.save(exist);
        }



        return this.usersRepository.save(users);
    }

    public List<Users> findAllUsers() {
        return this.usersRepository.findAll();
    }


    public Users findById(Long id) {
        return usersRepository.getOne(id);
    }

    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
