package com.example.esma.service;

import com.example.esma.model.User;
import com.example.esma.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void insertData(User User) {
        userRepository.save(User);
    }

    public void deleteData(String id) {
        userRepository.deleteById(id);
    }

    public void updateData(User User) {
        userRepository.save(User);
    }

    public User findUserByUserEmail(String email) {
        return userRepository.findById(email).orElseThrow();
    }

    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow();
    }
}
