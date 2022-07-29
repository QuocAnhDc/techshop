package com.example.techshop.service.iservice;

import com.example.techshop.dto.BrandDTO;

import java.util.List;

 public interface IBrandService {
   List<BrandDTO> getAllBrand();

   BrandDTO getBrandByName(String name);
   BrandDTO findById(Integer id);
   List<BrandDTO> pagination(Integer pageNumber, Integer pageSize);
   List<BrandDTO> pagination(Integer pageNumber, Integer pageSize, String col, String value);
   Integer countBrand (String col, String value);

   Integer countBrand ();

    BrandDTO  findEqualUnique(String property, Object value);

   void save(BrandDTO dto);

   BrandDTO update(BrandDTO dto);

   void delete(List<Integer> ids);
}
