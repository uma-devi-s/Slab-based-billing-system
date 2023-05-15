package com.example.Springboottask.DTO;

import com.example.Springboottask.Entity.Consumption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionDTO {
    private Integer ConsumptionId;
    private Integer CustomerId;
    private Date billDate;
    private Double TotalConsumption;

    private ConsumptionDTO convertConsumptionEntitytoDTO(Consumption consumption){
        ConsumptionDTO consumptionDTO = new ConsumptionDTO();
        consumptionDTO.setCustomerId(consumption.getCustomerId());
        consumptionDTO.setTotalConsumption(consumption.getTotalConsumption());
        return consumptionDTO;
    }
}
