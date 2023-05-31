package com.spm.ibooking.services;

import com.spm.ibooking.models.vo.UserVO;

public interface UserService {

    public String getAll();

    public String getById(Integer id);

    public String create(UserVO userVO);

    public String update(Integer id, UserVO userVO);

    public String delete(Integer id);

    public String validate(UserVO userVO);

}
