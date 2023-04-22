package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.BO.UserBO;
import com.spm.ibooking.models.DTO.UserDTO;
import com.spm.ibooking.models.PO.User;
import com.spm.ibooking.repositories.UserRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserBO> getAllUsers() {
        return BeanUtils.convertListTo(userRepository.findAll(), UserBO::new, true);
    }

    public UserBO getUserById(Integer id) {
        return BeanUtils.convertTo(userRepository.findById(id).orElse(null), UserBO::new, true);
    }

    public UserBO createUser(UserDTO userDTO) {
        User user = BeanUtils.convertTo(userDTO, User::new, true);
        return BeanUtils.convertTo(user, UserBO::new, true);
    }

    public UserBO updateUser(Integer id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // existingUser.setUsername(user.getUsername());
            // existingUser.setPassword(user.getPassword());
            // existingUser.setEmail(user.getEmail());
            // existingUser.setPhone(user.getPhone());
            user = BeanUtils.convertTo(userDTO, User::new, true);
            return BeanUtils.convertTo(userRepository.save(user), UserBO::new, true);
        }
        throw new ResourceNotFoundException("User not found with id " + id);
    }

    public void deleteUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }
}

