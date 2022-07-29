package com.example.techshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingSessionDTO {

  private Integer shoppingSessionId;

  private int total;

  private UserDTO userDTO;

  private List<CartItemDTO> cartItemDTOList;

}
