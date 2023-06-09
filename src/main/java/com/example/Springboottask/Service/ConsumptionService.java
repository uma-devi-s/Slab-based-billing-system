package com.example.Springboottask.Service;

import com.example.Springboottask.DTO.ConsumptionDTO;
import com.example.Springboottask.Entity.Consumption;
import com.example.Springboottask.Repository.AdminRepository;
import com.example.Springboottask.Repository.ConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionService {
    @Autowired
    private ConsumptionRepository consumptionRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private BillService bill;


    public List<Consumption> getConsumptionDetails() {
        return consumptionRepository.findAll();
    }


    public void addConsumption(ConsumptionDTO consumptionDTO, int adminId) {
        if(adminRepository.existsById(adminId)) {
            Consumption consumption = new Consumption();
            Consumption addConsumption =Consumption.builder()
                    .customerId(consumptionDTO.getCustomerId())
                    .TotalConsumption(consumptionDTO.getTotalConsumption())
                    .billDate(consumption.getBillDate())
                    .build();


//            consumption.setCustomerId(consumptionDTO.getCustomerId());
//            consumption.setTotalConsumption(consumptionDTO.getTotalConsumption());
            consumptionRepository.save(addConsumption);
            bill.BillCalculation(addConsumption.getCustomerId(),addConsumption.getTotalConsumption());
        }
    }
}
