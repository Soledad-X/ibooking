package com.spm.ibooking.services;

import com.spm.ibooking.models.vo.ReservationVO;

public interface ReservationService {
    
    public String getAll();

    public String getById(Integer id);

    public String create(ReservationVO reservationVO);

    public String update(Integer id, ReservationVO reservationVO);

    public String delete(Integer id);

    public String getUserById(Integer id);

    public String getSeatById(Integer id);

    public String getSignInById(Integer id);
}
