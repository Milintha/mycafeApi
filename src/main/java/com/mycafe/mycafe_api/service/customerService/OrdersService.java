package com.mycafe.mycafe_api.service.customerService;


import com.mycafe.mycafe_api.model.canteenmodel.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> getAllOrders();

    long getorders();

    int getDelivered();

    int getPending();
}
