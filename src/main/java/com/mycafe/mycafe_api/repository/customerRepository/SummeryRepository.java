package com.mycafe.mycafe_api.repository.customerRepository;


import com.mycafe.mycafe_api.model.canteenmodel.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummeryRepository extends JpaRepository<Summary,Integer> {

   /* @Query("select s.date, s.income from summery s where s.sum_id=:sum_id")
    List<Summery[]> getDateAndIncome(@Param("sum_id") int sum_id);

*/
}
