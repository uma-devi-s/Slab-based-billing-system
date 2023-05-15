package com.example.Springboottask.Repository;

import com.example.Springboottask.Entity.Slab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlabRepository extends JpaRepository<Slab,Integer> {
    @Query("select minunit,maxunit,price from Slab")
    List<Object[]> SlabList();
    @Query("select maxunit,price from Slab order by slabId")
    List<Object[]> SlabPriceList();
}
