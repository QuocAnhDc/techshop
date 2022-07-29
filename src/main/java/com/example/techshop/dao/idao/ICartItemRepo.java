package com.example.techshop.dao.idao;

import com.example.techshop.entity.CartItemEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


 public interface ICartItemRepo {

   boolean addProductToCart(Integer cusId, Integer productId);

   boolean updateCartItem(Integer cusId, Integer productId, int quantity);

   void updateProductQuantity(Integer productId, int changedQuantity);

   boolean deleteCartItem(Integer cusId, Integer productId, HttpServletRequest request,
      HttpServletResponse response);

   CartItemEntity findCartItem(Integer sessionId, Integer productId);

   List<CartItemEntity> getCartGreater30Day();

   List<CartItemEntity> getCartItemsByCusId(Integer cusId);

   void addCartInCookieToCus(Integer cusId, HttpServletRequest request,
      HttpServletResponse response);
}
