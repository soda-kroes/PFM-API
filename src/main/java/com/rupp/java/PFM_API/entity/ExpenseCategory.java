package com.rupp.java.PFM_API.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "expense_category")
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
}
