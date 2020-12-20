package com.sda.auction.services;

import com.sda.auction.entitites.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    List<User> findAllUsers();
    Optional<User> findById(int id);
    void deleteById(int id);
    User updateUser(User user, int id) throws Exception;
}
