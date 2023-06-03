package com.spm.ibooking.services;

import com.spm.ibooking.models.vo.BuildingVO;

public interface BuildingService {
    
    public String getAll();

    public String getById(Integer id);

    public String create(BuildingVO buildingVO);

    public String update(Integer id, BuildingVO buildingVO);

    public String delete(Integer id);

    public String getRoomsById(Integer id);

    public String getRoomsByName(String name);

    public String getCampusById(Integer id);

    public String getCampusByName(String name);
}
