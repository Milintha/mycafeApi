package com.mycafe.mycafe_api.repository.customerRepository;


import com.mycafe.mycafe_api.model.canteenmodel.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update wallet w set  w.balance=:bal where w.wallet_id=:id ", nativeQuery = true)
    void updatebalance(@Param("id") Integer id, @Param("bal") Integer bal);

    @javax.transaction.Transactional
    @Modifying
    @Query(value="insert into (auth_user_id,date,balance ) Wallet values(:auth_user_id,:date,:balance )",nativeQuery = true)
    int addNewWallet(@Param("auth_user_id")Integer auth_user_id, @Param("date")String date, @Param("balance")float balance);

    @Query(value="select * from wallet where auth_user_id=?1 ",nativeQuery = true)
    public Wallet getWalletByAuthUserRole(int auth_user_id);


    @javax.transaction.Transactional
    @Modifying
    @Query(value = "update wallet w set w.balance=:balance and w.date=:date where w.wallet_id=:wallet_id",nativeQuery=true)
    int rechargeWallet(@Param("wallet_id") int wallet_id,@Param("date") String date,@Param("balance") float balance);

}
