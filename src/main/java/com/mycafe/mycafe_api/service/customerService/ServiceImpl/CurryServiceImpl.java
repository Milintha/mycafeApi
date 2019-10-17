package com.mycafe.mycafe_api.service.customerService.ServiceImpl;


import com.mycafe.mycafe_api.model.canteenmodel.Curry;
import com.mycafe.mycafe_api.repository.customerRepository.CurryRepository;
import com.mycafe.mycafe_api.service.customerService.ICurryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurryServiceImpl implements ICurryService {
    @Autowired
    private CurryRepository curryRepository;

    @Override
    public boolean addCurry(Curry curry) {
        Curry save = curryRepository.save(curry);
        curryRepository.flush();
        save.getCurry_id();

        return save.getCurry_id() != 0;
    }

    @Override
    public List<Curry> searchCurryByName(String name) {
        return curryRepository.getCurryByCurry_name(name);
    }

}
