package com.example.techshop.utils.convert.list;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.utils.convert.OrderDetailConverter;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailListConverter {

  public static List<OrderDetailDTO> entity2Dto(List<OrderDetailEntity> entities) {
    List<OrderDetailDTO> dtos = new ArrayList<OrderDetailDTO>();
    for (OrderDetailEntity entity : entities) {
      OrderDetailDTO dto = new OrderDetailDTO();
      dto = OrderDetailConverter.entity2Dto(entity);
      dtos.add(dto);
    }
    return dtos;
  }

  public static List<OrderDetailEntity> dto2Entity(List<OrderDetailDTO> dtos) {
    List<OrderDetailEntity> entities = new ArrayList<OrderDetailEntity>();
    for (OrderDetailDTO dto : dtos) {
      OrderDetailEntity entity = new OrderDetailEntity();
      entity = OrderDetailConverter.dto2Entity(dto);
      entities.add(entity);
    }
    return entities;
  }

}
