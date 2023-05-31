package com.spm.ibooking.services;

import com.spm.ibooking.models.vo.SignInVO;

public interface SignInService {
    public String getAll();

    public String getById(Integer id);

    public String create(SignInVO signInVO);

    public String update(Integer id, SignInVO signInVO);

    public String delete(Integer id);
}
