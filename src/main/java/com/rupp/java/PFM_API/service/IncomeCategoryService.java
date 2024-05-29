package com.rupp.java.PFM_API.service;

import com.rupp.java.PFM_API.dto.request.IncomeCategoryRequest;
import com.rupp.java.PFM_API.entity.IncomeCategory;
import com.rupp.java.PFM_API.exception.AlreadyExistException;

import java.util.List;

public interface IncomeCategoryService {
    IncomeCategory createIncomeCategory(IncomeCategoryRequest incomeCategoryRequest) throws Exception;
    List<IncomeCategory> getAllIncomeCategories() throws Exception;
    IncomeCategory getIncomeCategoryById(Long id) throws Exception;
    IncomeCategory updateIncomeCategory(Long id,IncomeCategoryRequest incomeCategoryRequest) throws Exception;
    boolean deleteIncomeCategory(Long id) throws Exception;
}
