package com.example.Springboottask.Service;

import com.example.Springboottask.DTO.CustomerDTO;
import com.example.Springboottask.Entity.Consumption;
import com.example.Springboottask.Entity.Customer;
import com.example.Springboottask.Repository.ConsumptionRepository;
import com.example.Springboottask.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ConsumptionRepository consumptionRepository;
//    private ConsumptionService consumptionService;


    public List<Customer> getAllCustomers() {
//        List<Customer> customers = new ArrayList<>();
        return customerRepository.findAll();
    }




    public String addCustomer(CustomerDTO customerDTO) {
        // convert dto to entity
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPhno(customerDTO.getPhno());
        customer.setEmail(customerDTO.getEmail());
        customerRepository.save(customer);

        Consumption consumption = new Consumption();
        consumption.setCustomerId(customer.getCustomerId());
        consumption.setBillDate(consumption.getBillDate());
        consumption.setTotalConsumption(0.0);
        consumptionRepository.save(consumption);
        return "Customer registered";
    }

    public Customer updateCustomer(Integer customerId, CustomerDTO customerDTO) {

//        Customer newCustomer = Customer.builder()
//                .name(customerDTO.getName())
//                .phno(customerDTO.getPhno())
//                .email()
//                .build();
        Customer ExistingCustomer = customerRepository.findById(customerId).get();
        ExistingCustomer.setName(customerDTO.getName());
        ExistingCustomer.setPhno(customerDTO.getPhno());
        ExistingCustomer.setEmail(customerDTO.getEmail());
        customerRepository.save(ExistingCustomer);
        return ExistingCustomer;
    }

    public String deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
        return "Customer details deleted";
    }
}
