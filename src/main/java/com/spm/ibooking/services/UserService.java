package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.dto.UserDto;
import com.spm.ibooking.models.po.User;
import com.spm.ibooking.repositories.UserRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        return BeanUtils.convertListTo(userRepository.findAll(), UserDto::new, true);
    }

    public UserDto getById(Integer id) {
        return BeanUtils.convertTo(userRepository.findById(id).orElse(null), UserDto::new, true);
    }

    public UserDto create(UserDto userDto) {
        User user = BeanUtils.convertTo(userDto, User::new, true);
        return BeanUtils.convertTo(userRepository.save(user), UserDto::new, true);
    }

    public UserDto update(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            BeanUtils.copyTo(userDto, user, true);
            return BeanUtils.convertTo(userRepository.save(user), UserDto::new, true);
        }
        throw new ResourceNotFoundException("User not found with id " + id);
    }

    public void delete(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }

    public UserDto validate(UserDto userDto) {
        User user = null;
        if (userDto.getUsername() != null)
            user = userRepository.findByUsername(userDto.getUsername()).orElse(null);
        else if(userDto.getEmail() != null)
            user = userRepository.findByEmail(userDto.getEmail()).orElse(null);
        else
            user = userRepository.findByPhone(userDto.getPhone()).orElse(null);
        if (user != null && userDto.getPassword().equals(user.getPassword()))
            return BeanUtils.convertTo(user, UserDto::new, true);
        else
            return null;
    }
}

