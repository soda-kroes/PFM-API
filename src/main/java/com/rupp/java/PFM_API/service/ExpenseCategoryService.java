package com.rupp.java.PFM_API.service;

import com.rupp.java.PFM_API.dto.request.ExpenseCategoryRequest;
import com.rupp.java.PFM_API.dto.request.IncomeCategoryRequest;
import com.rupp.java.PFM_API.entity.ExpenseCategory;
import com.rupp.java.PFM_API.entity.IncomeCategory;

import java.util.List;

public interface ExpenseCategoryService {
    ExpenseCategory create(ExpenseCategoryRequest expenseCategoryRequest) throws Exception;
    List<ExpenseCategory> getAll() throws Exception;
    ExpenseCategory getById(Long id) throws Exception;
    ExpenseCategory update(Long id,ExpenseCategoryRequest expenseCategoryRequest) throws Exception;
    boolean delete(Long id) throws Exception;
}
