package com.example.techshop.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable,T> {
  List<T> findAll();
  T update(T entity);
  T save(T entity);
  T findById(ID id);
  Integer delete(List<ID> ids);
  T findEqualUnique(String property,Object value);
}