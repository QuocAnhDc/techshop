package com.example.techshop.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

  private Integer orderItemId;

  private Integer quantity;

  private ProductDTO productDTO;

  private OrderDetailDTO orderDetailDTO;

}
