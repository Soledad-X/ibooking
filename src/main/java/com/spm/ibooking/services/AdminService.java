package com.spm.ibooking.services;

import com.spm.ibooking.models.vo.AdminVO;

public interface AdminService {

    public String getAll();

    public String getById(Integer id);

    public String create(AdminVO adminVO);

    public String update(Integer id, AdminVO adminVO);

    public String delete(Integer id);

    public String validate(AdminVO adminVO);
}
