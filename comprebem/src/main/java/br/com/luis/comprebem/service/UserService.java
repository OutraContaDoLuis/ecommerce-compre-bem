package br.com.luis.comprebem.service;

import br.com.luis.comprebem.entity.User;
import br.com.luis.comprebem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User create(User user) {
        userRepository.save(user);

        return user;
    }

    public User update(User user) {
        User entity = userRepository.findById(user.getId()).orElseThrow();

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setAddress(user.getAddress());

        return entity;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
