package com.example.techshop.utils.convert.list;

import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.utils.convert.CartItemConverter;

import java.util.ArrayList;
import java.util.List;

public class CartItemListConverter {

  public static List<CartItemDTO> entity2Dto(List<CartItemEntity> entities) {
    List<CartItemDTO> dtos = new ArrayList<CartItemDTO>();
    for (CartItemEntity entity : entities) {
      CartItemDTO dto = new CartItemDTO();
      dto = CartItemConverter.entity2Dto(entity);
      dtos.add(dto);
    }
    return dtos;
  }

  public static List<CartItemEntity> dto2Entity(List<CartItemDTO> dtos) {
    List<CartItemEntity> entities = new ArrayList<CartItemEntity>();
    for (CartItemDTO dto : dtos) {
      CartItemEntity entity = new CartItemEntity();
      entity = CartItemConverter.dto2Entity(dto);
      entities.add(entity);
    }
    return entities;
  }

}
