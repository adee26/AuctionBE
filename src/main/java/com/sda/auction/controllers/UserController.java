package com.sda.auction.controllers;

import com.sda.auction.entitites.User;
import com.sda.auction.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    public Optional<User> findUserById(@PathVariable int id){
        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User editUser(@RequestBody User user, @PathVariable int id) throws Exception {
        return userService.updateUser(user, id);
    }
}
