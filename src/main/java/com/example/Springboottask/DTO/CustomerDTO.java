package com.example.Springboottask.DTO;

import com.example.Springboottask.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer CustomerId;
    private String name;
    private String phno;
    private String email;

    private CustomerDTO convertCustomerEntityToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhno(customer.getPhno());

        return customerDTO;
    }
}
