package com.example.techshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO  {
  
  private Integer categoryId;
  
  private String description;

  private String name;

  private List<ProductDTO> productDTOList;
}
