package com.br.pedeplux.controllers;

import com.br.pedeplux.models.User;
import com.br.pedeplux.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId){
        return ResponseEntity.ok().body(userService.findUserById(userId));
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user){
        user = userService.insertUser(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(user.getUserId())
                .toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User newUser){
        newUser = userService.updateUser(userId, newUser);
        return ResponseEntity.ok().body(newUser);
    }
}
