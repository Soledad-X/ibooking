package com.spm.ibooking.services.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.User;
import com.spm.ibooking.models.vo.UserVO;
import com.spm.ibooking.repositories.UserRepository;
import com.spm.ibooking.services.UserService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public String getAll() {
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, userRepository.findAll());
    }

    @Override
    public String getById(Integer id) {

        if(userRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, userRepository.findById(id).get());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(UserVO userVO) {
        
        User user = userRepository.findByUsernameOrEmailOrPhone(userVO.getUsername(), userVO.getEmail(), userVO.getPhone()).orElse(null);
        if(user == null) {
            user = new User();
            BeanUtils.copyProperties(userVO, user);
            userRepository.save(user);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, user);
        } else {
            if(userVO.getUsername().equals(user.getUsername()))
                return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The username already exists.");
            else if(userVO.getEmail().equals(user.getEmail()))
                return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The email already exists.");
            else
                return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The phone already exists.");
        }
    }

    @Override
    public String update(Integer id, UserVO userVO) {
        
        if(userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            UpdateUtil.copyNullProperties(userVO, user);
            userRepository.save(user);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, user);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String delete(Integer id) {
        
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseUtil.response(ResponseStatus.SUCCESS);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String validate(UserVO userVO) {

        User user = userRepository.findByUsernameOrEmailOrPhone(userVO.getUsername(), userVO.getEmail(), userVO.getPhone()).orElse(null);
        if (user == null) {
            return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The username does not exist.");
        } else if (!user.getPassword().equals(userVO.getPassword())) {
            return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "Account or password error.");
        } else {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            BeanUtils.copyProperties(user, userVO);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, token);
        }
    }

    @Override
    public String getReservationsById(Integer id) {

        if(userRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, userRepository.findById(id).get().getReservations());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

}
