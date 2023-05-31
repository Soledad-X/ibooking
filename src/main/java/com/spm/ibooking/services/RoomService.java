package com.spm.ibooking.services;


import com.spm.ibooking.models.vo.RoomVO;

public interface RoomService {

    public String getAll();

    public String getById(Integer id);

    public String create(RoomVO roomVO);

    public String update(Integer id, RoomVO roomVO);

    public String delete(Integer id);
}
