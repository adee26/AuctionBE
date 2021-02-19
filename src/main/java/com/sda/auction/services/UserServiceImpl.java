package com.sda.auction.services;

import com.sda.auction.DTO.UserDTO;
import com.sda.auction.entitites.User;
import com.sda.auction.entitites.enums.UserRole;
import com.sda.auction.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        user.setUserRole(UserRole.USER);
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
        try{
            Optional<User> newUser = Optional.ofNullable(user);
            User oldUser = userRepository.findById(id)
                    .orElseThrow(()-> new Exception("User not found!"));
            oldUser.setName(newUser.map(User::getName).orElse(oldUser.getName()));
            oldUser.setEmail(newUser.map(User::getEmail).orElse(oldUser.getEmail()));
            oldUser.setPassword(newUser.map(User::getPassword).orElse(oldUser.getPassword()));
            oldUser.setAddress(newUser.map(User::getAddress).orElse(oldUser.getAddress()));
            oldUser.setUserRole(newUser.map(User::getUserRole).orElse(oldUser.getUserRole()));
            oldUser.setAccountType(newUser.map(User::getAccountType).orElse(oldUser.getAccountType()));
            oldUser.setBiddingList(newUser.map(User::getBiddingList).orElse(oldUser.getBiddingList()));
            oldUser.setPurchasingList(newUser.map(User::getPurchasingList).orElse(oldUser.getPurchasingList()));

            return userRepository.save(oldUser);

        }catch (Exception e){
            throw new RuntimeException("User not found");
        }

    }

    @Override
    public boolean login(UserDTO userDTO){
        boolean isLoggedIn = false;
        Optional<User> user = userRepository.findUserByEmail(userDTO.getEmail());
        if(user.isPresent()){
            if(user.get().getPassword().equals(userDTO.getPassword())){
                isLoggedIn = true;
            }
        }
        return isLoggedIn;
    }

    @Override
    public int getUserIdByEmail(String email) throws Exception{
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.isPresent()){
            return user.get().getId();
        }
        throw new Exception("User not found");
    }
}
