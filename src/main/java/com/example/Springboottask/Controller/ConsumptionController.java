package com.example.Springboottask.Controller;

import com.example.Springboottask.DTO.ConsumptionDTO;
import com.example.Springboottask.Entity.BillEntity;
import com.example.Springboottask.Entity.Consumption;
import com.example.Springboottask.Service.BillService;
import com.example.Springboottask.Service.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsumptionController {
    @Autowired
    private ConsumptionService consumptionService;
    @Autowired
    private BillService billService;

    @GetMapping("/consumption")
    public List<Consumption> getConsumptionDetails(){
        return consumptionService.getConsumptionDetails();
    }

    @PostMapping("/consumption/add/{adminId}")
    public void addConsumption(@RequestBody ConsumptionDTO consumptionDTO, @PathVariable int adminId)
    {
        consumptionService.addConsumption(consumptionDTO,adminId);
    }

    @GetMapping("/bills/{adminId}")
    public List<BillEntity> getAllBills(@PathVariable Integer adminId){
        return billService.getAllBill(adminId);
    }
    @GetMapping("/bill/{customerId}")
    public List<BillEntity> getBill(@PathVariable Integer customerId){
        return billService.getBill(customerId);
    }

}
