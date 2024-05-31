package com.rupp.java.PFM_API.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExpenseCategoryRequest {
    @JsonProperty("name")
    private String name;
}
