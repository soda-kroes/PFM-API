package com.rupp.java.PFM_API.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "income_category")
public class IncomeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
}
