package com.mycafe.mycafe_api.service.customerService;


import com.mycafe.mycafe_api.model.canteenmodel.Summary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SummeryService {

    public List<Summary> getAllSummery();

    //public List<Summery[]> getDateAndIncome(int summery_id);
}
