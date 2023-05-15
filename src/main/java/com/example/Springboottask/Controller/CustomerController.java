package com.example.Springboottask.Controller;

import com.example.Springboottask.DTO.CustomerDTO;
import com.example.Springboottask.Entity.Customer;
import com.example.Springboottask.Service.BillService;
import com.example.Springboottask.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillService billService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @PostMapping("/customers/add")

    public String addCustomer(@RequestBody CustomerDTO customerDTO){

        customerService.addCustomer(customerDTO);
        return "Customer registred";
    }

    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Integer customerId){

        return customerService.updateCustomer(customerId,customerDTO);

    }

    @DeleteMapping("/customers/delete/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId){

        return customerService.deleteCustomer(customerId);
    }

}

