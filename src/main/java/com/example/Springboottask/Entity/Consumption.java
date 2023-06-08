package com.example.Springboottask.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Consumption")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Consumption {

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ConsumptionId;
    private Integer customerId;
    private LocalDateTime billDate = LocalDateTime.now();
    private Double TotalConsumption;



}

