package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DO.UserDO;
import com.spm.ibooking.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDO getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserDO> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDO createUser(UserDO user) {
        return userRepository.save(user);
    }

    public UserDO updateUser(Integer id, UserDO user) {
        Optional<UserDO> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserDO existingUser = optionalUser.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            return userRepository.save(existingUser);
        }
        throw new ResourceNotFoundException("User not found with id " + id);
    }

    public void deleteUser(Integer id) {
        Optional<UserDO> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }
}

