package com.example.techshop.dao.idao;

import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.entity.ProductEntity;

import java.util.List;

public interface ICategoryRepo {
   List<BrandEntity> getBrandInCate(Integer cateId);
   CategoryEntity findCategoryByName(String name);
   List<ProductEntity> getNewProductsByCategoryId(Integer id);

}
