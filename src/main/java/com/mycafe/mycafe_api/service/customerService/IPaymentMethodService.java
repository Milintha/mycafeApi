package com.mycafe.mycafe_api.service.customerService;

import com.mycafe.mycafe_api.model.canteenmodel.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentMethodService extends JpaRepository<PaymentMethod,Integer> {

}
