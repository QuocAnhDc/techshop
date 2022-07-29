package com.example.techshop.service.iservice;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dto.ProductDTO;

import java.util.List;
import java.util.Map;

 public interface IProductService {

   List<ProductDTO> getAllProduct();

   void save(ProductDTO productDTO) throws Exception;

   ProductDTO productUpdate(ProductDTO dto) throws Exception;

   void deleteProduct(List<Integer> ids);


   Object[] getProducts(Map<String, Object> properties);

   Map<String, Object> searchProperties(ProductCommand command);

   List<ProductDTO> getNewProducts();

   List<ProductDTO> getIsSaleProducts();

   ProductDTO findEqualUnique(String property, Object value);

   List<ProductDTO> pagingnation(Integer pageNumber, Integer pageSize);

   List<ProductDTO> pagingnation(Integer pageNumber, Integer pageSize, String col,
      String value);

   List<ProductDTO> pagingnation(Integer pageNumber, Integer pageSize, String col,
      boolean sale);

   Integer CountProduct();

   Integer CountProduct(String col, String value);

   Integer CountProduct(String col, boolean value);

   ProductDTO findById(Integer id);

}
