package com.spm.ibooking.services;

import com.spm.ibooking.models.vo.SeatVO;

public interface SeatService {

    public String getAll();

    public String getById(Integer id);

    public String create(SeatVO seatVO);

    public String update(Integer id, SeatVO seatVO);

    public String delete(Integer id);
}
