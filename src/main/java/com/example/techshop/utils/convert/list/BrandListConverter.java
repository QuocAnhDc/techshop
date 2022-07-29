package com.example.techshop.utils.convert.list;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.utils.convert.BrandConverter;

import java.util.ArrayList;
import java.util.List;

public class BrandListConverter {

  public static List<BrandDTO> entity2Dto(List<BrandEntity> entities) {
    List<BrandDTO> dtos = new ArrayList<BrandDTO>();
    for (BrandEntity entity : entities) {
      BrandDTO dto = new BrandDTO();
      dto = BrandConverter.entity2Dto(entity);
      dtos.add(dto);
    }
    return dtos;
  }

  public static List<BrandEntity> dto2Entity(List<BrandDTO> dtos) {
    List<BrandEntity> entities = new ArrayList<BrandEntity>();
    for (BrandDTO dto : dtos) {
      BrandEntity entity = new BrandEntity();
      entity = BrandConverter.dto2Entity(dto);
      entities.add(entity);
    }
    return entities;
  }
}
