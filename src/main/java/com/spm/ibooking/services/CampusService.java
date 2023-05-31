package com.spm.ibooking.services;

import com.spm.ibooking.models.vo.CampusVO;

public interface CampusService {
    
    public String getAll();

    public String getById(Integer id);

    public String create(CampusVO campusVO);

    public String update(Integer id, CampusVO campusVO);

    public String delete(Integer id);
}
