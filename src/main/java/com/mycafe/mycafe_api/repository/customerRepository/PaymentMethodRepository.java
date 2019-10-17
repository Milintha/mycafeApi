package com.mycafe.mycafe_api.repository.customerRepository;


import com.mycafe.mycafe_api.model.canteenmodel.PaymentMethod;
import com.mycafe.mycafe_api.model.canteenmodel.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer> {

    @Query(value="select * from payment_method where method_desc=?1 ",nativeQuery = true)
    public Wallet getPaymentMethodByMethod_desc(String method_desc);
}
