package com.example.Springboottask.Repository;

import com.example.Springboottask.Entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<BillEntity,Integer> {
    @Query(value = "SELECT * FROM bill WHERE customer_id =:customerId ORDER BY bill_date DESC LIMIT 1;", nativeQuery = true)
    List<BillEntity> BillsByCustomerId(@Param("customerId") Integer customerId);
}
