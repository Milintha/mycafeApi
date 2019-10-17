package com.mycafe.mycafe_api.service.customerService;

import com.mycafe.mycafe_api.exception.PaymentException;
import com.mycafe.mycafe_api.exception.WalletException;
import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import com.mycafe.mycafe_api.model.loginmodel.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPaymentService {
    public ResponseEntity<Boolean> insertPayment(User user, Payment payment) throws PaymentException, WalletException;
    public ResponseEntity<List<Payment>> getAllPaymentsByDate(String date) throws PaymentException, WalletException;
    public ResponseEntity< List<Payment>> getAllPaymentsBetweenDates(String date1,String date2) throws PaymentException,WalletException;
}
