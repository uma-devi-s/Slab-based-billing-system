package com.example.Springboottask.Controller;

import com.example.Springboottask.DTO.SlabDTO;
import com.example.Springboottask.Entity.Admin;
import com.example.Springboottask.Entity.Slab;
import com.example.Springboottask.Repository.AdminRepository;
import com.example.Springboottask.Service.SlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SlabController {
    @Autowired
    private SlabService slabService;
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/slab/{adminId}")
    public List<Slab> getSlabRates(@PathVariable Admin adminId){
        return slabService.getSlabRates(adminId);
    }

    @PostMapping("/slab/add/{adminId}")
    public String addSlab(@RequestBody SlabDTO slabDTO,@PathVariable int adminId){
        slabService.addSlab(adminId,slabDTO);
        return "Slab added";
    }

    @PutMapping("/slab/{slabId}/{adminId}")
    public String updateSlab(@RequestBody SlabDTO slabDTO,@PathVariable Integer slabId,@PathVariable Admin adminId){

        slabService.updateSlab(slabId,slabDTO,adminId);
        return "Slab updated";
    }

    @DeleteMapping("/slab/delete/{slabId}/{adminId}")
    public String deleteSlab(@PathVariable Integer slabId,@PathVariable Admin adminId){
         slabService.deleteSlab(slabId,adminId);
         return "slab deleted";
    }
}
