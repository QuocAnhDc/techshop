package com.example.techshop.utils;

import com.example.techshop.service.serviceimpl.*;

public class  STServiceUtil {

  private static BrandService brandService = null;
  private static CartItemService cartItemService = null;
  private static CategoryService categoryService = null;
  private static OrderDetailService orderDetailService = null;
  private static OrderItemService orderItemService = null;
  private static ProductService productService = null;
  private static RoleService roleService = null;
  private static ShoppingSessionService shoppingSessionService = null;
  private static UserService userService = null;

  public static BrandService getBrandService() {
    if (brandService == null) {
      brandService = new BrandService();
    }
    return brandService;
  }

  public static CartItemService getCartItemService() {
    if (cartItemService == null) {
      cartItemService = new CartItemService();
    }
    return cartItemService;
  }

  public static CategoryService getCategoryService() {
    if (categoryService == null) {
      categoryService = new CategoryService();
    }
    return categoryService;
  }

  public static OrderDetailService getOrderDetailService() {
    if (orderDetailService == null) {
      orderDetailService = new OrderDetailService();
    }
    return orderDetailService;
  }

  public static OrderItemService getOrderItemService() {
    if (orderItemService == null) {
      orderItemService = new OrderItemService();
    }
    return orderItemService;
  }

  public static ProductService getProductService() {
    if (productService == null) {
      productService = new ProductService();
    }
    return productService;
  }

  public static RoleService getRoleService() {
    if (roleService == null) {
      roleService = new RoleService();
    }
    return roleService;
  }

  public static ShoppingSessionService getShoppingSessionService() {
    if (shoppingSessionService == null) {
      shoppingSessionService = new ShoppingSessionService();
    }
    return shoppingSessionService;
  }

  public static UserService getUserService() {
    if (userService == null) {
      userService = new UserService();
    }
    return userService;
  }

}
