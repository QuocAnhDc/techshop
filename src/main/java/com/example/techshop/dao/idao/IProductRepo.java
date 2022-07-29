package com.example.techshop.dao.idao;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.entity.ProductEntity;

import java.util.List;
import java.util.Map;

 public interface IProductRepo {
   Object[] searchResult(Map<String, Object> properties);

   Map<String, Object> searchProperties(ProductCommand command);

   List<ProductEntity> getNewProducts();

   List<ProductEntity> getIsSaleOffProducts();

}
