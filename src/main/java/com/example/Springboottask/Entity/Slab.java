package com.example.Springboottask.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Slab")
@AllArgsConstructor
@NoArgsConstructor
public class Slab {
    @Id
    @GeneratedValue
    private int slabId;
    private int minunit;
    private int maxunit;
    private double price;

}
