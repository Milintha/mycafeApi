package com.mycafe.mycafe_api.service.customerService;


import com.mycafe.mycafe_api.model.canteenmodel.Curry;

import java.util.List;

public interface ICurryService {
    public boolean addCurry(Curry curry);


    //for customer
    public List<Curry> searchCurryByName(String name);


}
