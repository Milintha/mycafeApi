package com.mycafe.mycafe_api.service.customerService;


import com.mycafe.mycafe_api.model.canteenmodel.Canteen;

import java.util.List;

public interface ICanteenService {
    //get all details of a canteen using id
    public Canteen getCanteenDetail(int canteen_id);

    //insert canteen
    public boolean addCanteen(Canteen canteen);

    //add notice by id
    public boolean addNotice(int canteen_id,String notice);

    //update open close times by id
    public boolean updateOpenTime(int canteen_id,String openTime);
    public boolean updateCloseTime(int canteen_id,String closeTime);
    public boolean updateOpenCloseTime(int canteen_id,String openTime,String closeTime);

}

