package com.example.techshop.dao.idao;

import com.example.techshop.entity.BrandEntity;

public interface IBrandRepo {
  BrandEntity findBrandByName(String name);
}
