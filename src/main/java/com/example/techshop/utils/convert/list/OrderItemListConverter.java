package com.example.techshop.utils.convert.list;

import com.example.techshop.dto.OrderItemDTO;
import com.example.techshop.entity.OrderItemEntity;
import com.example.techshop.utils.convert.OrderItemConverter;

import java.util.ArrayList;
import java.util.List;

public class OrderItemListConverter {

  public static List<OrderItemDTO> entity2Dto(List<OrderItemEntity> entities) {
    List<OrderItemDTO> dtos = new ArrayList<OrderItemDTO>();
    for (OrderItemEntity entity : entities) {
      OrderItemDTO dto = new OrderItemDTO();
      dto = OrderItemConverter.entity2Dto(entity);
      dtos.add(dto);
    }
    return dtos;
  }

  public static List<OrderItemEntity> dto2Entity(List<OrderItemDTO> dtos) {
    List<OrderItemEntity> entities = new ArrayList<OrderItemEntity>();
    for (OrderItemDTO dto : dtos) {
      OrderItemEntity entity = new OrderItemEntity();
      entity = OrderItemConverter.dto2Entity(dto);
      entities.add(entity);
    }
    return entities;
  }

}
