package com.example.techshop.controller.admin.product;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
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
import java.util.List;

@WebServlet("/admin/product")
public class ProductController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    try {
      //get data from page
      ProductCommand command = FormUtil.populate(ProductCommand.class, request);
      //pagingnation
      List<ProductDTO> listProduct =
          STServiceUtil.getProductService().pagingnation(command.getPage(),
              command.getMaxPageItems(), "name", command.getValue());
      command.setTotalItems(
          (STServiceUtil.getProductService().CountProduct("name", command.getValue())
              / command.getMaxPageItems()) + 1);
      //get list brand and category
      List<BrandDTO> listBrand = STServiceUtil.getBrandService().getAllBrand();
      List<CategoryDTO> listCategory = STServiceUtil.getCategoryService().getAllCategory();

      //send data to page
      checkMessage(request);
      request.setAttribute("products", listProduct);
      request.setAttribute("brands", listBrand);
      request.setAttribute("category", listCategory);
      request.setAttribute("pojo", command);

      RequestDispatcher dispatcher
          = this.getServletContext()
          .getRequestDispatcher("/views/admin/product/productManager.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }

  public void checkMessage(HttpServletRequest request) {
    String message = request.getParameter("message");
    if (message != null) {
      if (message.trim().equals("addSuccess")) {
        request.setAttribute("message", "Thêm sản phẩm thành công");
      } else if (message.trim().equals("updateSuccess")) {
        request.setAttribute("message", "Sửa sản phẩm thành công");
      } else if (message.trim().equals("delSuccess")) {
        request.setAttribute("message", "Xóa sản phẩm thành công");
      } else if (message.trim().equals("Error")) {
        request.setAttribute("message", "Có lỗi xảy ra");
      }
    }
  }
}
