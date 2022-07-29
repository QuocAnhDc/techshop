package com.example.techshop.controller.web.baseweb;

import com.example.techshop.command.CategoryCommand;
import com.example.techshop.command.ProductCommand;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      CategoryCommand categoryCommand = FormUtil.populate(CategoryCommand.class, request);
      ProductCommand productCommand = FormUtil.populate(ProductCommand.class, request);
      setCommandAttribute(categoryCommand, productCommand, request);

      RequestDispatcher dispatcher //
          = this.getServletContext().getRequestDispatcher("/views/web/baseweb/home.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }

  void setCommandAttribute(CategoryCommand categoryCommand,
      ProductCommand productCommand,
      HttpServletRequest request) {
    categoryCommand.setListResult(STServiceUtil.getCategoryService().getAllCategory());
    categoryCommand.setBrandInCate(
        STServiceUtil.getCategoryService().buildBrandInCate(categoryCommand.getListResult()));
    categoryCommand.setProductInCate(STServiceUtil.getCategoryService().buildProductInCate(
        categoryCommand.getListResult()));
    productCommand.setNewProducts(STServiceUtil.getProductService().getNewProducts());
    productCommand.setIsSaleProducts(STServiceUtil.getProductService().getIsSaleProducts());
    request.setAttribute("cateItems", categoryCommand);
    request.setAttribute("productItems", productCommand);
  }


}