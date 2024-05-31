package com.rupp.java.PFM_API.repository;

import com.rupp.java.PFM_API.entity.ExpenseCategory;
import com.rupp.java.PFM_API.entity.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {
    boolean existsByName(String name);
}
