package com.poc.hexaware.azurePoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

    public String apiPath;
    public String message;
    public String statusCode;
}
