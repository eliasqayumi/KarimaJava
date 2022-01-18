package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.User;
import com.example.schoolmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository UserRepository;

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public List<User> getAll() {
        return UserRepository.findAll();
    }

    public void insertData(User User) {
        UserRepository.save(User);
    }

    public void deleteData(String id) {
        UserRepository.deleteById(id);
    }

    public void updateData(User User) {
        UserRepository.save(User);
    }
}
