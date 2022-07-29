package com.example.techshop.utils.convert.list;

import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.convert.ProductConverter;

import java.util.ArrayList;
import java.util.List;

public class ProductListConverter {

  public static List<ProductDTO> entity2Dto(List<ProductEntity> entities) {
    List<ProductDTO> dtos = new ArrayList<ProductDTO>();
    for (ProductEntity entity : entities) {
      ProductDTO dto = new ProductDTO();
      dto = ProductConverter.entity2Dto(entity);
      dtos.add(dto);
    }
    return dtos;
  }

  public static List<ProductEntity> dto2Entity(List<ProductDTO> dtos) {
    List<ProductEntity> entities = new ArrayList<ProductEntity>();
    for (ProductDTO dto : dtos) {
      ProductEntity entity = new ProductEntity();
      entity = ProductConverter.dto2Entity(dto);
      entities.add(entity);
    }
    return entities;
  }

}
