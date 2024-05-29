package com.rupp.java.PFM_API.controller;

import com.rupp.java.PFM_API.dto.request.IncomeCategoryRequest;
import com.rupp.java.PFM_API.dto.response.StatusResponse;
import com.rupp.java.PFM_API.entity.IncomeCategory;
import com.rupp.java.PFM_API.service.IncomeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/income-category")
public class IncomeCategoryController {
    private final IncomeCategoryService incomeCategoryService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody IncomeCategoryRequest incomeCategoryRequest) throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponse statusResponse = new StatusResponse();
        IncomeCategory incomeCategory = incomeCategoryService.createIncomeCategory(incomeCategoryRequest);
        if (incomeCategory != null) {
            statusResponse.setErrCode(200);
            statusResponse.setErrMsg("Income category created successfully");
            response.put("data", incomeCategory);
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
        List<IncomeCategory> incomeCategories = incomeCategoryService.getAllIncomeCategories();
        if (incomeCategories.isEmpty()){
            statusResponse.setErrCode(204); // No Content
            statusResponse.setErrMsg("Your Content Unexceptionable!");
            response.put("data", incomeCategories);
        }else {
            statusResponse.setErrCode(200);
            statusResponse.setErrMsg("Income category list retrieved successfully");
            response.put("data", incomeCategories);
        }
        response.put("status", statusResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
