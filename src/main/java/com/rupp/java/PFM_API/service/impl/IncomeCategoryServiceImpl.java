package com.rupp.java.PFM_API.service.impl;

import com.rupp.java.PFM_API.dto.request.IncomeCategoryRequest;
import com.rupp.java.PFM_API.entity.IncomeCategory;
import com.rupp.java.PFM_API.exception.AlreadyExistException;
import com.rupp.java.PFM_API.exception.NotFoundException;
import com.rupp.java.PFM_API.repository.IncomeCategoryRepository;
import com.rupp.java.PFM_API.service.IncomeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IncomeCategoryServiceImpl implements IncomeCategoryService {
    private final IncomeCategoryRepository incomeCategoryRepository;

    @Override
    public IncomeCategory createIncomeCategory(IncomeCategoryRequest incomeCategoryRequest) throws Exception {
        IncomeCategory incomeCategory = new IncomeCategory();
        incomeCategory.setName(incomeCategoryRequest.getName());

        boolean find = incomeCategoryRepository.existsByName(incomeCategoryRequest.getName());
        if (find) {
            throw new AlreadyExistException("Income category not available.");
        }else{
           try {
               return incomeCategoryRepository.save(incomeCategory);
           }catch (Exception ex){
               throw new Exception(ex);
           }
        }
    }

    @Override
    public List<IncomeCategory> getAllIncomeCategories() throws Exception {
        try {
            return incomeCategoryRepository.findAll();
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @Override
    public IncomeCategory getIncomeCategoryById(Long id) throws Exception {
        return incomeCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Income category with id " + id + " not found."));
    }

    @Override
    public IncomeCategory updateIncomeCategory(Long id,IncomeCategoryRequest incomeCategoryRequest) throws Exception {
        //check id have or not
        IncomeCategory incomeCategory = incomeCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Income category with id " + id + " not found."));
        incomeCategory.setName(incomeCategoryRequest.getName());
        return incomeCategoryRepository.save(incomeCategory);
    }

    @Override
    public boolean deleteIncomeCategory(Long id) throws Exception {
        boolean find = false;
        IncomeCategory incomeCategory = incomeCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Income category with id " + id + " not found."));
        if (Objects.equals(incomeCategory.getId(), id)) {
            incomeCategoryRepository.delete(incomeCategory);
            find = true;
        }
        return find;
    }
}
