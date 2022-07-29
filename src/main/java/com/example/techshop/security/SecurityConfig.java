package com.example.techshop.security;

import java.util.*;

public class SecurityConfig {

  public static final String ROLE_ADMIN = "ADMIN";
  public static final String ROLE_CUSTOMER = "CUSTOMER";

  // String: Role
  // List<String>: urlPatterns.
  private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

  static {
    init();
  }

  private static void init() {

    // Cấu hình cho vai trò "EMPLOYEE".
    List<String> adminUrlPattern = new ArrayList<String>();
    adminUrlPattern.add("/admin");
    adminUrlPattern.add("/admin/product");
    adminUrlPattern.add("/admin/product/edit");
    adminUrlPattern.add("/admin/product/delete");
    adminUrlPattern.add("/admin/product/sale");

    adminUrlPattern.add("/admin/brand");
    adminUrlPattern.add("/admin/brand/edit");
    adminUrlPattern.add("/admin/brand/delete");

    adminUrlPattern.add("/admin/category");
    adminUrlPattern.add("/admin/category/edit");
    adminUrlPattern.add("/admin/category/delete");

    adminUrlPattern.add("/admin/order");
    adminUrlPattern.add("/admin/order/edit");

    adminUrlPattern.add("/admin/user");
    adminUrlPattern.add("/admin/user/edit");
    adminUrlPattern.add("/admin/user/delete");

    mapConfig.put(ROLE_ADMIN, adminUrlPattern);

    // Cấu hình cho vai trò "MANAGER".
    List<String> cusUrlPattern = new ArrayList<String>();
    cusUrlPattern.add("/checkout");
    mapConfig.put(ROLE_CUSTOMER, cusUrlPattern);
  }

  public static Set<String> getAllAppRoles() {
    return mapConfig.keySet();
  }

  public static List<String> getUrlPatternsForRole(String role) {
    return mapConfig.get(role);
  }

}
