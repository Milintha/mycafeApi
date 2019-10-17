package com.mycafe.mycafe_api.service.customerService.ServiceImpl;

import com.mycafe.mycafe_api.model.canteenmodel.Canteen;
import com.mycafe.mycafe_api.repository.customerRepository.CanteenRepository;
import com.mycafe.mycafe_api.service.customerService.ICanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenServiceImpl implements ICanteenService {
    @Autowired
    private CanteenRepository canteenRepository;

    @Override
    public Canteen getCanteenDetail(int canteen_id) {
        return canteenRepository.findCanteensByCanteen_id(canteen_id);
    }

    @Override
    public boolean addCanteen(Canteen canteen) {
        int isAdd = canteenRepository.insertCanteen(canteen.getUser().getId(), canteen.getName(), canteen.getOpen(), canteen.getClose(), canteen.getNotice());
        //int isAdd=canteenRepository.save(canteen);

        if(isAdd>0) {
            return true;
        }else{

            return false;
        }
    }

    @Override
    public boolean addNotice(int canteen_id, String notice) {
        int isAdd=canteenRepository.updateCanteenSetNotice(canteen_id,notice);
        if(isAdd>0) {
            return true;
        }else{

            return false;
        }
    }

    @Override
    public boolean updateOpenTime(int canteen_id,String openTime) {
        int isUpdate=canteenRepository.updateCanteenSetOpen(canteen_id, openTime);
        if(isUpdate>0) {
            return true;
        }else{

            return false;
        }
    }

    @Override
    public boolean updateCloseTime(int canteen_id,String closeTime) {
    int isUpdate=canteenRepository.updateCanteenSetClose(canteen_id, closeTime);
        if(isUpdate>0) {
            return true;
        }else{

            return false;
        }
    }


    @Override
    public boolean updateOpenCloseTime(int canteen_id,String openTime, String closeTime) {
        int isUpdate=canteenRepository.updateCanteenSetOpenClose(canteen_id, openTime, closeTime);
        if(isUpdate>0) {
            return true;
        }else{

            return false;
        }
    }
}
