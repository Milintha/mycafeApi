package com.mycafe.mycafe_api.repository.customerRepository;


import com.mycafe.mycafe_api.model.canteenmodel.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CanteenRepository extends JpaRepository<Canteen,Integer> {


    @Query(value="select * from canteen c where c.canteen_id=?1",nativeQuery = true)
    public Canteen findCanteensByCanteen_id(Integer canteen_id);

    @Transactional
    @Modifying
    @Query(value="insert into canteen (auth_user_id,name,open,close,notice) values(:auth_user_id,:name,:open,:close,:notice)",nativeQuery = true)
    int insertCanteen(@Param("auth_user_id")Integer auth_user_id, @Param("name")String name, @Param("open") String time, @Param("close") String close, @Param("notice")String notice);

    @Transactional
    @Modifying
    @Query(value = "update canteen c set c.notice=:notice where c.canteen_id=:canteen_id",nativeQuery=true)
    int updateCanteenSetNotice(@Param("canteen_id") int canteen_id,@Param("notice") String notice);

    @Transactional
    @Modifying
    @Query(value = "update canteen c set c.open=:open where c.canteen_id=:canteen_id",nativeQuery=true)
    int updateCanteenSetOpen(@Param("canteen_id") int canteen_id,@Param("open") String open);

    @Transactional
    @Modifying
    @Query(value = "update canteen c set c.close=:close where c.canteen_id=:canteen_id",nativeQuery=true)
    int updateCanteenSetClose(@Param("canteen_id") int canteen_id,@Param("close") String close);

    @Transactional
    @Modifying
    @Query(value = "update canteen c set c.open=:open and c.close=:close where c.canteen_id=:canteen_id",nativeQuery=true)
    int updateCanteenSetOpenClose(@Param("canteen_id") int canteen_id,@Param("open") String open,@Param("close") String close);
}
