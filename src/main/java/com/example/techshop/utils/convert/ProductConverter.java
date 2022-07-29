package com.example.techshop.utils.convert;

import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.ProductEntity;

public class ProductConverter {

  public static ProductDTO entity2Dto(ProductEntity entity) {
    ProductDTO dto = new ProductDTO();
    dto.setProductId(entity.getProductId());
    dto.setDescription(entity.getDescription());
    dto.setPhoto(entity.getPhoto());
    dto.setPrice(entity.getPrice());
    dto.setName(entity.getName());
    dto.setQuantity(entity.getQuantity());
    dto.setSale(entity.isSale());
    dto.setBrandDTO(BrandConverter.entity2Dto(entity.getBrandEntity()));
    dto.setCreatedDate(entity.getCreatedDate());
    dto.setCategoryDTO(CategoryConverter.entity2Dto(entity.getCategoryEntity()));
    return dto;
  }

  public static ProductEntity dto2Entity(ProductDTO dto) {
    ProductEntity entity = new ProductEntity();
    entity.setProductId(dto.getProductId());
    entity.setDescription(dto.getDescription());
    entity.setPhoto(dto.getPhoto());
    entity.setPrice(dto.getPrice());
    entity.setName(dto.getName());
    entity.setSale(dto.isSale());
    entity.setQuantity(dto.getQuantity());
    entity.setBrandEntity(BrandConverter.dto2Entity(dto.getBrandDTO()));
    entity.setCreatedDate(dto.getCreatedDate());
    entity.setCategoryEntity(CategoryConverter.dto2Entity(dto.getCategoryDTO()));
    return entity;
  }

}
