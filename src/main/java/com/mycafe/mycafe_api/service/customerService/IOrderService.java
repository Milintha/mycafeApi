package com.mycafe.mycafe_api.service.customerService;


import com.mycafe.mycafe_api.exception.OrderException;
import com.mycafe.mycafe_api.exception.PaymentException;
import com.mycafe.mycafe_api.exception.WalletException;
import com.mycafe.mycafe_api.model.canteenmodel.Orders;
import com.mycafe.mycafe_api.payloads.OrderDetailDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderService {
    public ResponseEntity<?> placeNewOrder(OrderDetailDTO orderDetailDTO)throws OrderException, PaymentException, WalletException;
    public OrderDetailDTO getOrderByCustomerId(int customerId)throws OrderException;
    public OrderDetailDTO deleteOrderByCustomerId(int orderId)throws OrderException;
    public List<Orders> getOrdersByOwnerId(int ownerId)throws OrderException;

}
