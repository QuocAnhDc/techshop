package com.example.techshop.dao.repository;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dao.AbstractDao;
import com.example.techshop.dao.idao.IProductRepo;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo extends AbstractDao<Integer, ProductEntity> implements IProductRepo {

  @Override
  public Object[] searchResult(Map<String, Object> properties) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(ProductEntity.class);
    Transaction transaction = session.beginTransaction();
    try {
      if (properties.containsKey("brandId")) {
        Integer brandId = (Integer) properties.get("brandId");
        if (brandId != null && brandId > 0) {
          criteria.add(Restrictions.eq("brandEntity.brandId", brandId));
        }
      }

      if (properties.containsKey("cateId")) {
        Integer cateId = (Integer) properties.get("cateId");
        if (cateId != null && cateId > 0) {
          criteria.add(Restrictions.eq("categoryEntity.categoryId", cateId));
        }
      }

      if (properties.containsKey("sort")) {
        String sort = (String) properties.get("sort");
        if (sort != null && !sort.isEmpty()) {
          String[] orCriteria = sort.split("-");
          if (orCriteria[1].equals("ASC")) {
            criteria.addOrder(Order.asc(orCriteria[0]));
          } else if (orCriteria[1].equals("DESC")) {
            criteria.addOrder(Order.desc(orCriteria[0]));
          }
        }
      }

      if (properties.containsKey("name")) {
        String name = (String) properties.get("name");
        if (name != null && !name.isEmpty()) {
          criteria.add(Restrictions.ilike("name", "%" + name + "%"));
        }
      }

      if (properties.containsKey("minPrice")) {
        Integer minPrice = (Integer) properties.get("minPrice");
        if (minPrice != null && minPrice > 0) {
          criteria.add(Restrictions.gt("price", minPrice));
        }
      }

      if (properties.containsKey("maxPrice")) {
        Integer maxPrice = (Integer) properties.get("minPrice");
        if (maxPrice != null && maxPrice > 0) {
          criteria.add(Restrictions.lt("price", maxPrice));
        }
      }

      Integer productCount = criteria.list().size();

      if (properties.containsKey("firstIndex")) {
        Integer firstIndex = (Integer) properties.get("firstIndex");
        if (firstIndex != null && firstIndex >= 0) {
          criteria.setFirstResult(firstIndex);
        }
      }

      if (properties.containsKey("maxResult")) {
        Integer maxResult = (Integer) properties.get("maxResult");
        if (maxResult != null && maxResult >= 0) {
          criteria.setMaxResults(maxResult);
        }
      }
      transaction.commit();
      return new Object[]{criteria.list(), productCount};
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
  }

  @Override
  public Map<String, Object> searchProperties(ProductCommand command) {
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put("brandId", command.getBrand().getBrandId());
    properties.put("cateId", command.getCategory().getCategoryId());
    properties.put("sort", command.getSort());
    properties.put("name", command.getSearchName());
    properties.put("minPrice", command.getMinPrice());
    properties.put("maxPrice", command.getMaxPrice());
    properties.put("firstIndex", command.getFirstIndex());
    properties.put("maxResult", command.getMaxPageItems());
    return properties;
  }

  @Override
  public List<ProductEntity> getNewProducts() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(ProductEntity.class);
    Transaction transaction = session.beginTransaction();
    List<ProductEntity> products = new ArrayList<ProductEntity>();
    try {
      criteria.addOrder(Order.desc("createdDate"));
      criteria.setFirstResult(0);
      criteria.setMaxResults(5);
      products = criteria.list();
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
    return products;
  }

  @Override
  public List<ProductEntity> getIsSaleOffProducts() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(ProductEntity.class);
    Transaction transaction = session.beginTransaction();
    List<ProductEntity> products = new ArrayList<ProductEntity>();
    try {
      criteria.add(Restrictions.eq("sale", true));
      products = criteria.list();
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
    return products;
  }

}
