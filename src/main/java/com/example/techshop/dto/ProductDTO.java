package com.example.techshop.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ProductDTO {

  private Integer productId;

  private String description;

  private String name;

  private Integer price;

  private Integer quantity;

  private String photo;

  private Timestamp createdDate;

  private boolean sale;

  private List<CartItemDTO> cartItemDTOList;

  private List<OrderItemDTO> orderItemDTOList;

  private CategoryDTO categoryDTO;

  private BrandDTO brandDTO;

}
