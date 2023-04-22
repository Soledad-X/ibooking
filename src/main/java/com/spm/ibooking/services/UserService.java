package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.bo.UserBo;
import com.spm.ibooking.models.dto.UserDto;
import com.spm.ibooking.models.po.User;
import com.spm.ibooking.repositories.UserRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserBo> getAllUsers() {
        return BeanUtils.convertListTo(userRepository.findAll(), UserBo::new, true);
    }

    public UserBo getUserById(Integer id) {
        return BeanUtils.convertTo(userRepository.findById(id).orElse(null), UserBo::new, true);
    }

    public UserBo createUser(UserDto userDto) {
        User user = BeanUtils.convertTo(userDto, User::new, true);
        return BeanUtils.convertTo(user, UserBo::new, true);
    }

    public UserBo updateUser(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // existingUser.setUsername(user.getUsername());
            // existingUser.setPassword(user.getPassword());
            // existingUser.setEmail(user.getEmail());
            // existingUser.setPhone(user.getPhone());
            user = BeanUtils.convertTo(userDto, User::new, true);
            return BeanUtils.convertTo(userRepository.save(user), UserBo::new, true);
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

