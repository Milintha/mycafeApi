package com.mycafe.mycafe_api.service.customerService.ServiceImpl;


import com.mycafe.mycafe_api.config.MyDateTime;
import com.mycafe.mycafe_api.exception.OrderException;
import com.mycafe.mycafe_api.exception.PaymentException;
import com.mycafe.mycafe_api.exception.WalletException;
import com.mycafe.mycafe_api.model.canteenmodel.Orders;
import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import com.mycafe.mycafe_api.model.canteenmodel.RecipeCategory;
import com.mycafe.mycafe_api.model.loginmodel.User;
import com.mycafe.mycafe_api.payloads.OrderDetailDTO;
import com.mycafe.mycafe_api.repository.customerRepository.OrderRepository;
import com.mycafe.mycafe_api.service.customerService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentServiceImpl paymentService;

    @Autowired
    private MyDateTime myDateTime;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = OrderException.class)
    public ResponseEntity<?> placeNewOrder(OrderDetailDTO orderDetailDTO) throws OrderException, PaymentException, WalletException {
        User customer = orderDetailDTO.getAuthUserRole();
        String orderType = orderDetailDTO.getOrderType();
        Payment payment = orderDetailDTO.getPayment();
        int qty = orderDetailDTO.getQty();
        RecipeCategory recipeCategory = orderDetailDTO.getRecipeCategory();

        Orders newOrder=new Orders(customer,recipeCategory,qty,orderType,"1",myDateTime.getCurrentDate().getDate(),myDateTime.getCurrentDate().getTime());
        //call insert payment
        //save in order table

        Orders save = orderRepository.save(newOrder);
        orderRepository.flush();


        //paymentService.insertPayment(
        
        return null;
    }

    @Override
    public OrderDetailDTO getOrderByCustomerId(int customerId)throws OrderException {
        return null;
    }

    @Override
    public OrderDetailDTO deleteOrderByCustomerId(int orderId)throws OrderException {
        return null;
    }

    @Override
    public List<Orders> getOrdersByOwnerId(int ownerId) throws OrderException{
        return null;
    }


}
