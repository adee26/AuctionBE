package com.sda.auction.services;

import com.sda.auction.entitites.User;
import com.sda.auction.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setCreationDate(Date.from(Instant.now()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, int id) throws Exception{
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            userOptional.get().setAddress(user.getAddress());
            userOptional.get().setAccountType(user.getAccountType());
            userOptional.get().setEmail(user.getEmail());
            userOptional.get().setName(user.getName());
            userOptional.get().setPassword(user.getPassword());
            return userRepository.save(userOptional.get());
        }else {
            throw new Exception("User not found");
        }
    }
}
