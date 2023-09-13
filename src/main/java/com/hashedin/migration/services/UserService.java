package com.hashedin.migration.services;

import com.hashedin.migration.entity.User;
import com.hashedin.migration.entity.Product;
import com.hashedin.migration.repository.UserRepository;
import com.hashedin.migration.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        if (!user.getEmail().isEmpty())
            return userRepository.save(user);
        else
            return null;
    }

    public User editUser(Long id, User user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setPassword(user.getPassword());
            existingUser.setUsername(user.getUsername());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Long getProductCount() {
        return productRepository.count();
    }
}