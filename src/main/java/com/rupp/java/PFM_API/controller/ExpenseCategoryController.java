package com.rupp.java.PFM_API.controller;

import com.rupp.java.PFM_API.dto.request.ExpenseCategoryRequest;
import com.rupp.java.PFM_API.dto.request.IncomeCategoryRequest;
import com.rupp.java.PFM_API.dto.response.StatusResponse;
import com.rupp.java.PFM_API.entity.ExpenseCategory;
import com.rupp.java.PFM_API.entity.IncomeCategory;
import com.rupp.java.PFM_API.service.ExpenseCategoryService;
import com.rupp.java.PFM_API.service.IncomeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expense-category")
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExpenseCategoryRequest expenseCategoryRequest) throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponse statusResponse = new StatusResponse();
        ExpenseCategory expenseCategory = expenseCategoryService.create(expenseCategoryRequest);
        if (expenseCategory != null) {
            statusResponse.setErrCode(200);
            statusResponse.setErrMsg("Expense category created successfully");
            response.put("data", expenseCategory);
        }else{
            statusResponse.setErrCode(204); // No Content
            statusResponse.setErrMsg("Your Content Unexceptionable!");
            response.put("data", null);
        }
        response.put("status", statusResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponse statusResponse = new StatusResponse();
        List<ExpenseCategory> expenseCategoryList = expenseCategoryService.getAll();
        if (expenseCategoryList.isEmpty()){
            statusResponse.setErrCode(204); // No Content
            statusResponse.setErrMsg("Your Content Unexceptionable!");
            response.put("data", expenseCategoryList);
        }else {
            statusResponse.setErrCode(200);
            statusResponse.setErrMsg("Income category list retrieved successfully");
            response.put("data", expenseCategoryList);
        }
        response.put("status", statusResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Long id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponse statusResponse = new StatusResponse();
        ExpenseCategory expenseCategory = expenseCategoryService.getById(id);
        if (expenseCategory == null) {
            statusResponse.setErrCode(204); // No Content
            statusResponse.setErrMsg("Your Content Unexceptionable!");
            response.put("data", expenseCategory);
        }else{
            statusResponse.setErrCode(200);
            statusResponse.setErrMsg("Income category retrieved successfully");
            response.put("data", expenseCategory);
        }
        response.put("status", statusResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody ExpenseCategoryRequest expenseCategoryRequest) throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponse statusResponse = new StatusResponse();
        ExpenseCategory expenseCategory = expenseCategoryService.update(id, expenseCategoryRequest);
        if (expenseCategory != null) {
            statusResponse.setErrCode(200);
            statusResponse.setErrMsg("Income category updated successfully");
            response.put("data", expenseCategory);
        }else{
            statusResponse.setErrCode(204);
            statusResponse.setErrMsg("Your Content Unexceptionable!");
            response.put("data", null);
        }
        response.put("status", statusResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponse statusResponse = new StatusResponse();
        boolean isDelete = expenseCategoryService.delete(id);
        if (isDelete) {
            statusResponse.setErrCode(200);
            statusResponse.setErrMsg("Expense category deleted successfully");
        }
        response.put("status", statusResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
