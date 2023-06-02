package com.spm.ibooking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.SignIn;
import com.spm.ibooking.models.vo.SignInVO;
import com.spm.ibooking.repositories.SignInRepository;
import com.spm.ibooking.services.SignInService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private SignInRepository signInRepository;

    @Override
    public String getAll() {
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, signInRepository.findAll());
    }

    @Override
    public String getById(Integer id) {

        if(signInRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, signInRepository.findById(id));
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(SignInVO signinVO) {

        SignIn signin = new SignIn();
        UpdateUtil.copyNullProperties(signinVO, signin);
        signInRepository.save(signin);
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, signin);
    }

    @Override
    public String update(Integer id, SignInVO signinVO) {

        if(signInRepository.existsById(id)) {
            SignIn signin = signInRepository.findById(id).get();
            UpdateUtil.copyNullProperties(signinVO, signin);
            signInRepository.save(signin);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, signin);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String delete(Integer id) {
        
        if(signInRepository.existsById(id)) {
            signInRepository.deleteById(id);
            return ResponseUtil.response(ResponseStatus.SUCCESS);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

}

