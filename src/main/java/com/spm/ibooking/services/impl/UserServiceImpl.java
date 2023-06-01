package com.spm.ibooking.services.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.User;
import com.spm.ibooking.models.vo.UserVO;
import com.spm.ibooking.repositories.UserRepository;
import com.spm.ibooking.services.UserService;
import com.spm.ibooking.utils.ResultUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public String getById(Integer id) {
        return ResultUtil.successWithData(userRepository.findById(id).orElse(null));
    }

    @Override
    public String create(UserVO userVO) {
        
        User user = userRepository.findByUsernameOrEmailOrPhone(userVO.getUsername(), userVO.getEmail(), userVO.getPhone()).orElse(null);
        if(user == null) {
            user = new User();
            BeanUtils.copyProperties(userVO, user);
            userRepository.save(user);
            userVO.setPassword(null);
            return ResultUtil.successWithData(userVO);
        } else {
            if(userVO.getUsername().equals(user.getUsername()))
                return ResultUtil.errorWithMessage("username 已存在");
            else if(userVO.getEmail().equals(user.getEmail()))
                return ResultUtil.errorWithMessage("email 已存在");
            else
                return ResultUtil.errorWithMessage("phone 已存在");
        }
    }

    @Override
    public String update(Integer id, UserVO userVO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String validate(UserVO userVO) {

        User user = userRepository.findByUsernameOrEmailOrPhone(userVO.getUsername(), userVO.getEmail(), userVO.getPhone()).orElse(null);
        if (user == null) {
            return ResultUtil.errorWithMessage("用户不存在");
        } else if (!user.getPassword().equals(userVO.getPassword())) {
            return ResultUtil.errorWithMessage("账户或密码错误");
        } else {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            user.setPassword(null); // 过滤
            BeanUtils.copyProperties(user, userVO);
            return ResultUtil.successWithDataAndMessage(userVO, token);
        }
    }

}
