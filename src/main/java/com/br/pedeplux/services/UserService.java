package com.br.pedeplux.services;

import com.br.pedeplux.models.User;
import com.br.pedeplux.repositories.UserRepository;
import com.br.pedeplux.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    };

    public User findUserById(Long userId){
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    public User insertUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User newUser){
        User user = userRepository.getReferenceById(userId);
        updateFildsUser(user, newUser);
        return userRepository.save(user);
    }

    public void updateFildsUser(User user, User newUser){
        user.setName(newUser.getName());
        user.setUsername(newUser.getUsername());
        user.setCellfone(newUser.getCellfone());
        user.setPassword(newUser.getPassword());
    }
}
