package com.example.techshop.utils.convert;

import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.entity.CartItemEntity;

public class CartItemConverter {

  public static CartItemDTO entity2Dto(CartItemEntity entity) {
    CartItemDTO dto = new CartItemDTO();
    dto.setCartItemId(entity.getCartItemId());
    dto.setQuantity(entity.getQuantity());
    dto.setProductDTO(ProductConverter.entity2Dto(entity.getProductEntity()));
    dto.setShoppingSessionDTO(
        ShoppingSessionConverter.entity2Dto(entity.getShoppingSessionEntity()));
    return dto;
  }

  public static CartItemEntity dto2Entity(CartItemDTO dto) {
    CartItemEntity entity = new CartItemEntity();
    entity.setCartItemId(dto.getCartItemId());
    entity.setQuantity(dto.getQuantity());
    entity.setProductEntity(ProductConverter.dto2Entity(dto.getProductDTO()));
    entity.setShoppingSessionEntity(
        ShoppingSessionConverter.dto2Entity(dto.getShoppingSessionDTO()));
    return entity;
  }

}
