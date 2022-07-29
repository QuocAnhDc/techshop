package com.example.techshop.utils.convert;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.entity.OrderDetailEntity;

public class OrderDetailConverter {

  public static OrderDetailDTO entity2Dto(OrderDetailEntity entity) {
    OrderDetailDTO dto = new OrderDetailDTO();
    dto.setOrderDetailId(entity.getOrderDetailId());
    dto.setIspaid(entity.getIspaid());
    dto.setTotal(entity.getTotal());
    dto.setPhoneNumber(entity.getPhoneNumber());
    dto.setAddress(entity.getAddress());
    dto.setCreatedDate(entity.getCreatedDate());
    dto.setUserDTO(UserConverter.entity2Dto(entity.getUserEntity()));
    return dto;
  }

  public static OrderDetailEntity dto2Entity(OrderDetailDTO dto) {
    OrderDetailEntity entity = new OrderDetailEntity();
    entity.setOrderDetailId(dto.getOrderDetailId());
    entity.setIspaid(dto.getIspaid());
    entity.setTotal(dto.getTotal());
    entity.setPhoneNumber(dto.getPhoneNumber());
    entity.setAddress(dto.getAddress());
    entity.setCreatedDate(dto.getCreatedDate());
    entity.setUserEntity(UserConverter.dto2Entity(dto.getUserDTO()));
    return entity;
  }
}
