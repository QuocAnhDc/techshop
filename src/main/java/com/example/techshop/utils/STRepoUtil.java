package com.example.techshop.utils;

import com.example.techshop.dao.repository.*;

public class STRepoUtil {

  private static BrandRepo brandRepo = null;
  private static CartItemRepo cartItemRepo = null;
  private static CategoryRepo categoryRepo = null;
  private static OrderDetailRepo orderDetailRepo = null;
  private static OrderItemRepo orderItemRepo = null;
  private static ProductRepo productRepo = null;
  private static RoleRepo roleRepo = null;
  private static ShoppingSessionRepo shoppingSessionRepo = null;
  private static UserRepo userRepo = null;


  public static BrandRepo getBrandRepo() {
    if (brandRepo == null) {
      brandRepo = new BrandRepo();
    }
    return brandRepo;
  }

  public static CartItemRepo getCartItemRepo() {
    if (cartItemRepo == null) {
      cartItemRepo = new CartItemRepo();
    }
    return cartItemRepo;
  }

  public static CategoryRepo getCategoryRepo() {
    if (categoryRepo == null) {
      categoryRepo = new CategoryRepo();
    }
    return categoryRepo;
  }

  public static OrderDetailRepo getOrderDetailRepo() {
    if (orderDetailRepo == null) {
      orderDetailRepo = new OrderDetailRepo();
    }
    return orderDetailRepo;
  }

  public static OrderItemRepo getOrderItemRepo() {
    if (orderItemRepo == null) {
      orderItemRepo = new OrderItemRepo();
    }
    return orderItemRepo;
  }

  public static ProductRepo getProductRepo() {
    if (productRepo == null) {
      productRepo = new ProductRepo();
    }
    return productRepo;
  }

  public static RoleRepo getRoleRepo() {
    if (roleRepo == null) {
      roleRepo = new RoleRepo();
    }
    return roleRepo;
  }

  public static ShoppingSessionRepo getShoppingSessionRepo() {
    if (shoppingSessionRepo == null) {
      shoppingSessionRepo = new ShoppingSessionRepo();
    }
    return shoppingSessionRepo;
  }

  public static UserRepo getUserRepo() {
    if (userRepo == null) {
      userRepo = new UserRepo();
    }
    return userRepo;
  }

}
