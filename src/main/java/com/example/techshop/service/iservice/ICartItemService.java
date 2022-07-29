package com.example.techshop.service.iservice;

import com.example.techshop.dto.CartItemDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 public interface ICartItemService {
   boolean addProductToCart(Integer cusId, Integer productId);
   void updateCartItem(Integer cusId, Integer productId, int quantity);

   void deleteCartItem(Integer cusId, Integer productId, HttpServletRequest request,
      HttpServletResponse response);

   void addCartInCookieToCus(Integer cusId, HttpServletRequest request,
      HttpServletResponse response);

   List<CartItemDTO> getCartItemsByCusId(Integer cusId);

   List<CartItemDTO> inCookieCartItems(HttpServletRequest request);

   Integer deleteCartItemGreater30Day();

   Integer countCartItemsGreater30Day();

}
