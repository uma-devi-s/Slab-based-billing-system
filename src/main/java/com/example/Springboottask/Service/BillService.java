package com.example.Springboottask.Service;

import com.example.Springboottask.Entity.BillEntity;
import com.example.Springboottask.Entity.Slab;
import com.example.Springboottask.Repository.AdminRepository;
import com.example.Springboottask.Repository.BillRepository;
import com.example.Springboottask.Repository.ConsumptionRepository;
import com.example.Springboottask.Repository.SlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillService {
    @Autowired
    private ConsumptionRepository consumptionRepository;
    @Autowired
    private SlabRepository slabRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private AdminRepository adminRepository;


    public String BillCalculation(Integer customer_id,Double TotalConsumption){
        Integer previousConsumption = consumptionRepository.findPreviousConsumption(customer_id);
        Double currentConsumption = TotalConsumption - previousConsumption;

//
        List<Slab> slabs = slabRepository.findAll();
        Double totalBill = slabs.stream()
                            .filter(n->n.getMinunit()<currentConsumption)
                            .mapToDouble(bill-> (Math.min(currentConsumption,bill.getMaxunit()) - bill.getMinunit()) * bill.getPrice())
                            .sum();



        /***********************************************************************************
        for(Slab slab : slabs ){
            if(currentConsumption - slab.getMaxunit() > 0){
                TotalBill = (slab.getMaxunit() - slab.getMinunit()) * slab.getPrice();
            }
            else{
                TotalBill = TotalBill+(currentConsumption - slab.getMinunit()) * slab.getPrice();
                break;
            }
        }
         ***********************************************************************************/
//        int first_count = 0;
//        List<Object[]> slabList = slabRepository.SlabList();
//
//        for (Object[] slabData : slabList){
//            Integer minUnit = (Integer) slabData[0];
//            Integer maxUnit = (Integer) slabData[1];
//            Double price = (Double) slabData[2];
//            first_count += 1;
//            if(currentConsumption>=minUnit && currentConsumption<=maxUnit){
//                Double consumption = currentConsumption-minUnit;
//                TotalBill = TotalBill + (consumption * price);
//                break;
//            }
//        }
//        List<Object[]> slabPriceList = slabRepository.SlabPriceList();
//        for(int i = 1; i< first_count; i++){
//            Object[] slabData = slabPriceList.get(i-1);
//            Integer maxUnit = (Integer) slabData[0];
//            Double price = (Double) slabData[1];
//            TotalBill = TotalBill+(maxUnit * price);
//        }
        addBill(customer_id,currentConsumption,totalBill);
        return "Bill updated";
    }


    public void addBill(Integer customerId, Double currentConsumption, Double billAmt) {
        BillEntity billEntity = new BillEntity();
        billEntity.setCustomerId(customerId);
        billEntity.setBillDate(billEntity.getBillDate());
        billEntity.setBillAmt(billAmt);
        billEntity.setCurrentConsumption(currentConsumption);
        billRepository.save(billEntity);
    }

    public List<BillEntity> getAllBill(Integer adminId) {
        if(adminRepository.existsById(adminId)){
            return billRepository.findAll();

        }
        return null;
    }

    public List<BillEntity> getBill(Integer customerId) {
        return billRepository.BillsByCustomerId(customerId);
    }
}

