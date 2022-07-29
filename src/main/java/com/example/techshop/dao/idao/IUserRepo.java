package com.example.techshop.dao.idao;

import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.entity.UserEntity;

public interface IUserRepo {
  UserEntity findUser(String email, String password);
  ShoppingSessionEntity findSessionByCusId(Integer cusId);
  boolean register(UserEntity user);
}
