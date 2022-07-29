package com.example.techshop.dto;

import lombok.Data;


@Data
public class CartItemDTO {
  
  private Integer cartItemId;
  
  private Integer quantity;
  
  private ShoppingSessionDTO shoppingSessionDTO;

  private ProductDTO productDTO;
}
