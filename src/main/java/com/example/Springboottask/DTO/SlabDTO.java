package com.example.Springboottask.DTO;

import com.example.Springboottask.Entity.Admin;
import com.example.Springboottask.Entity.Slab;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlabDTO {
    private Integer slabId;
    private int minunit;
    private Integer maxunit;
    private double price;
    private int adminId;

    @Autowired
    private Admin admin;
    private SlabDTO convertSlabEntityToDTO(Slab slab){
        SlabDTO slabDTO = new SlabDTO();

        slabDTO.setSlabId(slab.getSlabId());
//        slabDTO.setAdminId(admin.getAdminId());
        slabDTO.setMinunit(slab.getMinunit());
        slabDTO.setMaxunit(slab.getMaxunit());
        slabDTO.setPrice(slab.getPrice());

        return slabDTO;
    }
}
