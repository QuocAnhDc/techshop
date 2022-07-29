package com.example.techshop.controller.web.baseweb;

import com.example.techshop.command.BrandCommand;
import com.example.techshop.command.CategoryCommand;
import com.example.techshop.command.ProductCommand;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pDetail")
public class ProductDetailController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      CategoryCommand categoryCommand = FormUtil.populate(CategoryCommand.class, request);
      BrandCommand brandCommand = FormUtil.populate(BrandCommand.class, request);
      ProductCommand productCommand = FormUtil.populate(ProductCommand.class, request);
      setCommandAttribute(categoryCommand, brandCommand, request);

      int productId = productCommand.getPojo().getProductId();
      if (productId != 0) {
        ProductDTO dto = STServiceUtil.getProductService().findById(productId);
        request.setAttribute("product", dto);
      } else {
        response.sendRedirect("error");
      }

      response.setCharacterEncoding("UTF-8");
      request.setCharacterEncoding("UTF-8");
      RequestDispatcher dispatcher //
          = this.getServletContext().getRequestDispatcher("/views/web/baseweb/productDetail.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }

  void setCommandAttribute(CategoryCommand categoryCommand, BrandCommand brandCommand,
      HttpServletRequest request) {
    categoryCommand.setListResult(STServiceUtil.getCategoryService().getAllCategory());
    categoryCommand.setBrandInCate(
        STServiceUtil.getCategoryService().buildBrandInCate(categoryCommand.getListResult()));
    request.setAttribute("cateItems", categoryCommand);
    brandCommand.setListResult(STServiceUtil.getBrandService().getAllBrand());
    request.setAttribute("brandItems", brandCommand);
  }


}
