package com.example.Springboottask.Repository;

import com.example.Springboottask.Entity.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepository extends JpaRepository <Consumption,Integer>{
//    @Modifying
    @Query(value = "SELECT total_consumption FROM consumption WHERE customer_id =?1 ORDER BY bill_date DESC LIMIT 1;", nativeQuery = true)
    Integer findNewConsumption(Integer customerId);

    @Query(value = "SELECT total_consumption FROM consumption WHERE customer_id =?1 ORDER BY bill_date DESC LIMIT 1,1;", nativeQuery = true)
    Integer findPreviousConsumption(Integer customerId);


}
