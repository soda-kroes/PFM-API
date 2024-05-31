package com.rupp.java.PFM_API.service.impl;

import com.rupp.java.PFM_API.dto.request.ExpenseCategoryRequest;
import com.rupp.java.PFM_API.dto.request.IncomeCategoryRequest;
import com.rupp.java.PFM_API.entity.ExpenseCategory;
import com.rupp.java.PFM_API.entity.IncomeCategory;
import com.rupp.java.PFM_API.exception.AlreadyExistException;
import com.rupp.java.PFM_API.exception.NotFoundException;
import com.rupp.java.PFM_API.repository.ExpenseCategoryRepository;
import com.rupp.java.PFM_API.repository.IncomeCategoryRepository;
import com.rupp.java.PFM_API.service.ExpenseCategoryService;
import com.rupp.java.PFM_API.service.IncomeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

@Service
@RequiredArgsConstructor
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    @Override
    public ExpenseCategory create(ExpenseCategoryRequest expenseCategoryRequest) throws Exception {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName(expenseCategoryRequest.getName());
        boolean find = expenseCategoryRepository.existsByName(expenseCategoryRequest.getName());
        if (find) {
            throw new AlreadyExistException("Expense category not available.");
        }else{
            try {
               return expenseCategoryRepository.save(expenseCategory);
            }catch (Exception ex){
                throw new Exception(ex);
            }
        }

    }

    @Override
    public List<ExpenseCategory> getAll() throws Exception {
        return expenseCategoryRepository.findAll();
    }

    @Override
    public ExpenseCategory getById(Long id) throws Exception {
        return expenseCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Expense category with id " + id + " not found."));
    }

    @Override
    public ExpenseCategory update(Long id, ExpenseCategoryRequest expenseCategoryRequest) throws Exception {
        //check id have or not
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Expense category with id " + id + " not found."));
        expenseCategory.setName(expenseCategoryRequest.getName());
        return expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    public boolean delete(Long id) throws Exception {
        boolean find = false;
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Expense category with id " + id + " not found."));
        if (Objects.equals(expenseCategory.getId(), id)) {
            expenseCategoryRepository.delete(expenseCategory);
            find = true;
        }
        return find;
    }
}
