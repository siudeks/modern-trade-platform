package com.crd.service.businessapigateway.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Response from api request.
 */
@Data
@Accessors(chain = true)
@ToString
public class ApiResponse {
  private String response;
}
