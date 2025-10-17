package com.br.pedeplux.services;

import com.br.pedeplux.models.User;
import com.br.pedeplux.repositories.UserRepository;
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
        return user.orElseThrow(() -> new NoSuchElementException("Usuario não encontrado"));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
