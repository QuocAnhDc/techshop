package com.example.techshop.service.serviceimpl;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.service.iservice.IProductService;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.ProductConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;

import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

  @Override
  public List<ProductDTO> getAllProduct() {
    List<ProductEntity> entities = STRepoUtil.getProductRepo().findAll();
    List<ProductDTO> dtos = ProductListConverter.entity2Dto(entities);
    return dtos;
  }

  @Override
  public void save(ProductDTO productDTO) throws Exception {
    ProductEntity entity = ProductConverter.dto2Entity(productDTO);
    entity = STRepoUtil.getProductRepo().save(entity);
    if (entity == null) {
      throw new Exception("Not save");
    }
  }

  @Override
  public ProductDTO productUpdate(ProductDTO dto) throws Exception {
    ProductEntity entity = ProductConverter.dto2Entity(dto);
    entity = STRepoUtil.getProductRepo().update(entity);
    if (entity == null) {
      throw new Exception("Not update");
    }
    dto = ProductConverter.entity2Dto(entity);
    return dto;
  }
  @Override
  public void deleteProduct(List<Integer> ids) {
    STRepoUtil.getProductRepo().delete(ids);
  }

  @Override
  public Object[] getProducts(Map<String, Object> properties) {
    Object[] entities = STRepoUtil.getProductRepo().searchResult(properties);
    List<ProductDTO> dtos = ProductListConverter.entity2Dto((List<ProductEntity>) entities[0]);
    Integer productCount = (Integer) entities[1];
    return new Object[]{dtos, productCount};
  }
  @Override
  public Map<String, Object> searchProperties(ProductCommand command) {
    return STRepoUtil.getProductRepo().searchProperties(command);
  }
  @Override
  public List<ProductDTO> getNewProducts() {
    List<ProductEntity> entities = STRepoUtil.getProductRepo().getNewProducts();
    return ProductListConverter.entity2Dto(entities);
  }
  @Override
  public List<ProductDTO> getIsSaleProducts() {
    List<ProductEntity> entities = STRepoUtil.getProductRepo().getIsSaleOffProducts();
    return ProductListConverter.entity2Dto(entities);
  }
  @Override
  public ProductDTO findEqualUnique(String property, Object value) {
    ProductEntity productEntity = STRepoUtil.getProductRepo().findEqualUnique(property, value);
    ProductDTO productDTO = ProductConverter.entity2Dto(productEntity);
    return productDTO;
  }
  @Override
  public List<ProductDTO> pagingnation(Integer pageNumber, Integer pageSize) {
    List<ProductEntity> entities = STRepoUtil.getProductRepo().pagination(pageNumber, pageSize);
    return ProductListConverter.entity2Dto(entities);

  }
  @Override
  public List<ProductDTO> pagingnation(Integer pageNumber, Integer pageSize, String col,
      String value) {
    List<ProductEntity> entities = STRepoUtil.getProductRepo()
        .pagination(pageNumber, pageSize, col, value);
    return ProductListConverter.entity2Dto(entities);

  }
  @Override
  public List<ProductDTO> pagingnation(Integer pageNumber, Integer pageSize, String col,
      boolean sale) {
    List<ProductEntity> entities = STRepoUtil.getProductRepo()
        .pagination(pageNumber, pageSize, col, sale);
    return ProductListConverter.entity2Dto(entities);
  }

  @Override
  public Integer CountProduct() {
    return STRepoUtil.getProductRepo().Count("productId");
  }

  @Override
  public Integer CountProduct(String col, String value) {
    return STRepoUtil.getProductRepo().Count("productId", col, value);
  }

  @Override
  public Integer CountProduct(String col, boolean value) {
    return STRepoUtil.getProductRepo().Count("productId", col, value);
  }

  @Override
  public ProductDTO findById(Integer id) {
    ProductEntity entity = STRepoUtil.getProductRepo().findById(id);
    ProductDTO ProductDTO = ProductConverter.entity2Dto(entity);
    return ProductDTO;
  }
}
