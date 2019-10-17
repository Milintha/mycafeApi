package com.mycafe.mycafe_api.repository.customerRepository;

import com.mycafe.mycafe_api.model.canteenmodel.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {

       /* long countByOrder_id(int order_id);*/

        @Query(value = "SELECT count(o.order_id) FROM Orders o ")
    public long countByOrder_id();


    @Transactional
    @Modifying
    @Query(value="insert into orders (auth_user_id,recipe_category_id,qty,order_type,status,date,time) values(:auth_user_id,:recipe_category_id,:qty,:order_type,:status,:date,:time)",nativeQuery = true)
    int insertOrder(@Param("auth_user_id")Integer auth_user_id, @Param("recipe_category_id")Integer recipe_category_id, @Param("qty") Integer qty, @Param("order_type") String order_type, @Param("status")boolean status, @Param("date")String date, @Param("time")String time) throws SQLException;



}
