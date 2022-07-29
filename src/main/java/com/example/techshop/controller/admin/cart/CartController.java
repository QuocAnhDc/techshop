package com.example.techshop.controller.admin.cart;

import com.example.techshop.utils.STServiceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/cart/delete")
public class CartController extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            STServiceUtil.getCartItemService().deleteCartItemGreater30Day();
            resp.sendRedirect("/admin");
        }catch (Exception e){
            resp.sendRedirect("/error");
        }
    }
}
