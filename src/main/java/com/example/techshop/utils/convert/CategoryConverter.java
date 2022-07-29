package com.example.techshop.utils.convert;

import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.entity.CategoryEntity;

public class CategoryConverter {

  public static CategoryDTO entity2Dto(CategoryEntity entity) {
    CategoryDTO dto = new CategoryDTO();
    dto.setDescription(entity.getDescription());
    dto.setName(entity.getName());
    dto.setCategoryId(entity.getCategoryId());
    return dto;
  }

  public static CategoryEntity dto2Entity(CategoryDTO dto) {
    CategoryEntity entity = new CategoryEntity();
    entity.setDescription(dto.getDescription());
    entity.setName(dto.getName());
    entity.setCategoryId(dto.getCategoryId());
    return entity;
  }

}
