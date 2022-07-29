package com.example.techshop.service.serviceimpl;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.service.iservice.ICategoryService;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import com.example.techshop.utils.convert.CategoryConverter;
import com.example.techshop.utils.convert.list.BrandListConverter;
import com.example.techshop.utils.convert.list.CategoryListConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CategoryService implements ICategoryService {

  @Override
  public List<CategoryDTO> getAllCategory() {
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo().findAll();
    List<CategoryDTO> dtos = CategoryListConverter.entity2Dto(entities);
    return dtos;
  }

  @Override
  public CategoryDTO getCategoryByName(String name) {
    CategoryEntity category = STRepoUtil.getCategoryRepo().findCategoryByName(name);
    return CategoryConverter.entity2Dto(category);
  }

  @Override
  public CategoryDTO findById(Integer id) {
    CategoryDTO dto = new CategoryDTO();
    CategoryEntity categoryEntity = STRepoUtil.getCategoryRepo().findById(id);
    dto = CategoryConverter.entity2Dto(categoryEntity);
    return dto;
  }

  @Override
  public List<BrandDTO> getBrandByCate(Integer cateId) {
    List<BrandEntity> entities = STRepoUtil.getCategoryRepo().getBrandInCate(cateId);
    List<BrandDTO> dtos = BrandListConverter.entity2Dto(entities);
    return dtos;
  }

  @Override
  public Map<CategoryDTO, List<BrandDTO>> buildBrandInCate(List<CategoryDTO> categoryDTOS) {
    Map<CategoryDTO, List<BrandDTO>> brandInCate = new TreeMap<CategoryDTO, List<BrandDTO>>();
    for (CategoryDTO category : categoryDTOS) {
      brandInCate.put(category,
          STServiceUtil.getCategoryService().getBrandByCate(category.getCategoryId()));
    }
    return brandInCate;
  }

  @Override
  public List<ProductDTO> getProductsByCateId(Integer cateId){
    List<ProductEntity> entities = STRepoUtil.getCategoryRepo().getNewProductsByCategoryId(cateId);
    List<ProductDTO> dtos = ProductListConverter.entity2Dto(entities);
    return dtos;
  }

  @Override
  public Map<CategoryDTO, List<ProductDTO>> buildProductInCate(List<CategoryDTO> categoryDTOS){
    Map<CategoryDTO, List<ProductDTO>> productInCate = new HashMap<CategoryDTO, List<ProductDTO>>();
    for (CategoryDTO category : categoryDTOS) {
      productInCate.put(category,
          STServiceUtil.getCategoryService().getProductsByCateId(category.getCategoryId()));
    }
    TreeMap<CategoryDTO, List<ProductDTO>> sortedList = new TreeMap<>();
    sortedList.putAll(productInCate);
    return sortedList;
  }


  @Override
  public List<CategoryDTO> pagination(Integer pageNumber, Integer pageSize) {
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo().pagination(pageNumber, pageSize);
    return CategoryListConverter.entity2Dto(entities);
  }
  @Override
  public List<CategoryDTO> pagination(Integer pageNumber, Integer pageSize, String col,
      String value) {
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo()
        .pagination(pageNumber, pageSize, col, value);
    return CategoryListConverter.entity2Dto(entities);
  }

  @Override
  public Integer countCategory() {
    return STRepoUtil.getCategoryRepo().Count("categoryId");
  }

  @Override
  public Integer countCategory(String col, String value) {
    return STRepoUtil.getCategoryRepo().Count("categoryId", col, value);
  }

  @Override
  public CategoryDTO findEqualUnique(String property, Object value) {
    CategoryEntity entity = STRepoUtil.getCategoryRepo().findEqualUnique(property, value);
    CategoryDTO categoryDTO = CategoryConverter.entity2Dto(entity);
    return categoryDTO;
  }
  @Override
  public void save(CategoryDTO dto) throws Exception {
    CategoryEntity entity = CategoryConverter.dto2Entity(dto);
    entity = STRepoUtil.getCategoryRepo().save(entity);
    if (entity == null) {
      throw new Exception("Not save");
    }
  }

  @Override
  public CategoryDTO update(CategoryDTO dto) throws Exception {
    CategoryEntity entity = CategoryConverter.dto2Entity(dto);
    entity = STRepoUtil.getCategoryRepo().update(entity);
    if (entity == null) {
      throw new Exception("Not update");
    }
    return CategoryConverter.entity2Dto(entity);
  }
  @Override
  public void delete(List<Integer> ids) {
    STRepoUtil.getCategoryRepo().delete(ids);
  }

}
