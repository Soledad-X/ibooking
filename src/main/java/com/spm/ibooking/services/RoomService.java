package com.spm.ibooking.services;


import com.spm.ibooking.models.vo.RoomVO;

public interface RoomService {

    public String getAll();

    public String getById(Integer id);

    public String create(RoomVO roomVO);

    public String update(Integer id, RoomVO roomVO);

    public String delete(Integer id);

    public String getBuildingById(Integer id);

    public String getSeatsById(Integer id);

    public String getBuildingByName(String name);

    public String getSeatsByName(String name);

}
