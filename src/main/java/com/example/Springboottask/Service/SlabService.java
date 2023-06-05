package com.example.Springboottask.Service;

import com.example.Springboottask.DTO.SlabDTO;
import com.example.Springboottask.Entity.Admin;
import com.example.Springboottask.Entity.Slab;
import com.example.Springboottask.Repository.AdminRepository;
import com.example.Springboottask.Repository.SlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlabService {
    @Autowired
    private SlabRepository slabRepository;
    @Autowired
    private AdminRepository adminRepository;

    public List<Slab> getSlabRates(Admin admin) {
        if(adminRepository.existsById(admin.getAdminId())){
        return slabRepository.findAll();
        }
        return null;
    }

    public void addSlab(int adminId,SlabDTO slabDTO) {
        if(adminRepository.existsById(adminId)){
            Slab slab = new Slab();
//            slab.setSlabId(slabDTO.getSlabId());
            slab.setMinunit(slabDTO.getMinunit());
            slab.setMaxunit(slabDTO.getMaxunit());
            slab.setPrice(slabDTO.getPrice());
            slabRepository.save(slab);
        }

    }

    public void updateSlab(Integer slabId, SlabDTO slabDTO, Admin admin) {

        if(adminRepository.existsById(admin.getAdminId())){
            Slab existingSlab = slabRepository.findById(slabId).get();
            existingSlab.setMinunit(slabDTO.getMinunit());
            existingSlab.setMaxunit(slabDTO.getMaxunit());
            existingSlab.setPrice(slabDTO.getPrice());
            slabRepository.save(existingSlab);
        }
    }

    public String deleteSlab(Integer slabId,Admin admin) {
        if(adminRepository.existsById(admin.getAdminId())) {
            slabRepository.deleteById(slabId);
        }
        return null;
    }
}
