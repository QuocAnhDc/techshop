package com.example.techshop.utils.convert;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.entity.BrandEntity;

public class BrandConverter {

  public static BrandDTO entity2Dto(BrandEntity entity) {
    BrandDTO dto = new BrandDTO();
    dto.setBrandId(entity.getBrandId());
    dto.setName(entity.getName());
    dto.setDescription(entity.getDescription());
    return dto;
  }

  public static BrandEntity dto2Entity(BrandDTO dto) {
    BrandEntity entity = new BrandEntity();
    entity.setBrandId(dto.getBrandId());
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
    return entity;
  }
}
