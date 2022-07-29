package com.example.techshop.controller.web.customer;

import com.example.techshop.command.CartItemCommand;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-cart-item")
public class DeleteProductController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      CartItemCommand command = FormUtil.populate(CartItemCommand.class, request);
      STServiceUtil.getCartItemService()
          .deleteCartItem(command.getCusId(), command.getProductId(), request, response);
      response.sendRedirect("/cart");
    } catch (Exception e) {
      response.sendRedirect("/error");

    }
  }
}
