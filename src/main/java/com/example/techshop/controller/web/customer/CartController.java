package com.example.techshop.controller.web.customer;

import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      UserDTO cus = (UserDTO) request.getSession().getAttribute("loginedUser");
      List<CartItemDTO> cartItems = new ArrayList<CartItemDTO>();
      Integer cusId = cus != null ? cus.getUserId() : -1;
      if (cusId == -1) {
        cartItems = STServiceUtil.getCartItemService().inCookieCartItems(request);
      } else {
        STServiceUtil.getCartItemService().addCartInCookieToCus(cusId, request, response);
        cartItems = STServiceUtil.getCartItemService().getCartItemsByCusId(cusId);
      }
      request.setAttribute("cartItems", cartItems);
      RequestDispatcher dispatcher //
          = request.getServletContext()
          .getRequestDispatcher("/views/web/customer/shoppingCart.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }
}
