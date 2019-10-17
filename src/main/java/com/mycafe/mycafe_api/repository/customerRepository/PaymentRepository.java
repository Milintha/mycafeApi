package com.mycafe.mycafe_api.repository.customerRepository;

import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Transactional
    @Modifying
    @Query(value="insert into (order_id,pay_method_id,amount,date,time ) payment values(:order_id,:pay_method_id,:amount,:date,:time)",nativeQuery = true)
    int addPayment(@Param("order_id")Integer order_id,@Param("pay_method_id")Integer pay_method_id,@Param("amount")float amount,@Param("date")String date,@Param("time") String time);

    public List<Payment> findPaymentsByDate(String date);

    public List<Payment> findPaymentsByDateBetween(String date1,String date2);
}
