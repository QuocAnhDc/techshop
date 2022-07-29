package com.example.techshop.controller.admin.product;


import com.example.techshop.command.ProductCommand;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/product/delete")
public class ProductDeleteController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {
      //get data from page
      ProductCommand command = FormUtil.populate(ProductCommand.class, req);
      //check conditions delete
      if (command.getIdDelete() != null) {
        List ids = new ArrayList();
        ids.add(command.getIdDelete());
        STServiceUtil.getProductService().deleteProduct(ids);
        resp.sendRedirect("/admin/product?message=delSuccess");
      } else {
        resp.sendRedirect("/admin/product");
      }
    } catch (Exception e) {
      resp.sendRedirect("/error");
    }

  }
}
