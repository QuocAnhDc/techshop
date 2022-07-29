package com.example.techshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class BrandDTO {

  private Integer brandId;

  private String description;

  private String name;

  private List<ProductDTO> productDTOList;

}
