package com.rupp.java.PFM_API.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IncomeCategoryRequest {
    @JsonProperty("name")
    private String name;
}
