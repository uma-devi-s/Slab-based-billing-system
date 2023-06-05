package com.example.Springboottask.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.*;


@Entity
@Data
@Table(name = "Customer")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer CustomerId;
    private String name;
    private String phno;
    private String email;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Consumption> consumption;


}
