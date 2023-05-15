package com.example.Springboottask.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Bill")
@AllArgsConstructor
@NoArgsConstructor
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billNo;
    private Integer customerId;
    private Double currentConsumption;
    private Double billAmt;
    private LocalDateTime billDate = LocalDateTime.now();
}
