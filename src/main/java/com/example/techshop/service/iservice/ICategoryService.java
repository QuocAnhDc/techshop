package com.example.techshop.service.iservice;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
  
   List<CategoryDTO> getAllCategory();

   CategoryDTO getCategoryByName(String name);

   CategoryDTO findById(Integer id);

   List<BrandDTO> getBrandByCate(Integer cateId);

   List<ProductDTO> getProductsByCateId(Integer cateId);

   Map<CategoryDTO, List<ProductDTO>> buildProductInCate(List<CategoryDTO> categoryDTOS);

   Map<CategoryDTO, List<BrandDTO>> buildBrandInCate(List<CategoryDTO> categoryDTOS);
  
   List<CategoryDTO> pagination(Integer pageNumber, Integer pageSize);

   List<CategoryDTO> pagination(Integer pageNumber, Integer pageSize, String col, String value);
    
   Integer countCategory ();

   Integer countCategory (String col, String value);

    CategoryDTO  findEqualUnique(String property, Object value);

   void save(CategoryDTO dto) throws Exception;

   CategoryDTO update(CategoryDTO dto) throws Exception;

   void delete(List<Integer> ids);
}
