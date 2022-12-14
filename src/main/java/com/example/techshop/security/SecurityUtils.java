package com.example.techshop.security;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {

  // Kiểm tra 'request' này có bắt buộc phải đăng nhập hay không.
  public static boolean isSecurityPage(HttpServletRequest request) {
    String urlPattern = UrlPatternUtils.getUrlPattern(request);
    Set<String> roles = SecurityConfig.getAllAppRoles();

    for (String role : roles) {
      //Lấy các url được truy cập của từng role
      List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
      //Kiểm tra xem url hiện tại có nằm trong các url yêu cầu Author hay không
      if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
        return true;
      }
    }
    return false;
  }

  // Kiểm tra 'request' này có vai trò phù hợp hay không?
  public static boolean hasPermission(HttpServletRequest request) {
    String urlPattern = UrlPatternUtils.getUrlPattern(request);

    Set<String> allRoles = SecurityConfig.getAllAppRoles();

    for (String role : allRoles) {
      if (!request.isUserInRole(role)) {
        continue;
      }
      List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
      if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
        return true;
      }
    }
    return false;
  }

}
