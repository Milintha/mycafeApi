package com.mycafe.mycafe_api.repository.customerRepository;

import com.mycafe.mycafe_api.model.canteenmodel.WalletHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface WalletHistoryRepository extends JpaRepository<WalletHistory,Integer> {

    @Transactional
    @Modifying
    @Query(value="insert into wallet_history (wallet_id,pay_id,payment,method,date,time) values(:wallet_id,:pay_id,:payment,:method,:date,:time)",nativeQuery = true)
    int insertWalletRecord(@Param("wallet_id")Integer wallet_id, @Param("pay_id")Integer pay_id, @Param("payment") Float payment, @Param("method") com.boot.mycafe.cafe.Service.Value.WalletType method, @Param("date")String date, @Param("time")String time);

}
