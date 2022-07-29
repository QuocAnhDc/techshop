package com.example.techshop.utils.convert;

import com.example.techshop.dto.ShoppingSessionDTO;
import com.example.techshop.entity.ShoppingSessionEntity;

public class ShoppingSessionConverter {

  public static ShoppingSessionDTO entity2Dto(ShoppingSessionEntity entity) {
    ShoppingSessionDTO dto = new ShoppingSessionDTO();
    dto.setUserDTO(UserConverter.entity2Dto(entity.getUserEntity()));
    dto.setShoppingSessionId(entity.getSessionId());
    dto.setTotal(entity.getTotal());
    return dto;
  }

  public static ShoppingSessionEntity dto2Entity(ShoppingSessionDTO dto) {
    ShoppingSessionEntity entity = new ShoppingSessionEntity();
    entity.setUserEntity(UserConverter.dto2Entity(dto.getUserDTO()));
    entity.setSessionId(dto.getShoppingSessionId());
    entity.setTotal(dto.getTotal());
    return entity;
  }

}
