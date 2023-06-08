package com.example.Springboottask.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Slab")
@SuperBuilder
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
