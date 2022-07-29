package com.example.techshop.utils.convert;

import com.example.techshop.dto.OrderItemDTO;
import com.example.techshop.entity.OrderItemEntity;

public class OrderItemConverter {

  public static OrderItemDTO entity2Dto(OrderItemEntity entity) {
    OrderItemDTO dto = new OrderItemDTO();
    dto.setOrderItemId(entity.getOrderItemId());
    dto.setQuantity(entity.getQuantity());
    dto.setProductDTO(ProductConverter.entity2Dto(entity.getProductEntity()));
    dto.setOrderDetailDTO(OrderDetailConverter.entity2Dto(entity.getOrderDetailEntity()));
    return dto;
  }

  public static OrderItemEntity dto2Entity(OrderItemDTO dto) {
    OrderItemEntity entity = new OrderItemEntity();
    entity.setOrderItemId(dto.getOrderItemId());
    entity.setQuantity(dto.getQuantity());
    entity.setProductEntity(ProductConverter.dto2Entity(dto.getProductDTO()));
    entity.setOrderDetailEntity(OrderDetailConverter.dto2Entity(dto.getOrderDetailDTO()));
    return entity;
  }

}
