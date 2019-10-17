package com.mycafe.mycafe_api.repository.customerRepository;


import com.mycafe.mycafe_api.model.canteenmodel.Curry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CurryRepository extends JpaRepository<Curry,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into curry(curry_name,detail) values(:curry_name,:detail)",nativeQuery = true)
    public int addNewCurry(@Param("curry_name")String curry_name,@Param("detail") String detail);

    @Query(value="select * from curry where curry_name like %?1 ",nativeQuery = true)
    public List<Curry> getCurryByCurry_name(String curry_name);
}
