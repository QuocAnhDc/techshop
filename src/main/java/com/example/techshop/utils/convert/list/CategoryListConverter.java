package com.example.techshop.utils.convert.list;

import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.utils.convert.CategoryConverter;

import java.util.ArrayList;
import java.util.List;

public class CategoryListConverter {

  public static List<CategoryDTO> entity2Dto(List<CategoryEntity> entities) {
    List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
    for (CategoryEntity entity : entities) {
      CategoryDTO dto = new CategoryDTO();
      dto = CategoryConverter.entity2Dto(entity);
      dtos.add(dto);
    }
    return dtos;
  }

  public static List<CategoryEntity> dto2Entity(List<CategoryDTO> dtos) {
    List<CategoryEntity> entities = new ArrayList<CategoryEntity>();
    for (CategoryDTO dto : dtos) {
      CategoryEntity entity = new CategoryEntity();
      entity = CategoryConverter.dto2Entity(dto);
      entities.add(entity);
    }
    return entities;
  }


}
