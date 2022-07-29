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

@WebServlet("/admin/product/sale")
public class ProductSaleController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    try {
      //get data from page
      ProductCommand command = FormUtil.populate(ProductCommand.class, request);

      //pagingnation list product sale
      List<ProductDTO> listProduct =
          STServiceUtil.getProductService().pagingnation(command.getPage(),
              command.getMaxPageItems(), "sale", true);
      command.setTotalItems(
          (STServiceUtil.getProductService().CountProduct("sale", true) / command.getMaxPageItems())
              + 1);

      // get brand and category
      List<BrandDTO> listBrand = STServiceUtil.getBrandService().getAllBrand();
      List<CategoryDTO> listCategory = STServiceUtil.getCategoryService().getAllCategory();

      // send data to page
      request.setAttribute("products", listProduct);
      request.setAttribute("brands", listBrand);
      request.setAttribute("category", listCategory);
      request.setAttribute("pojo", command);

      RequestDispatcher dispatcher
          = this.getServletContext().getRequestDispatcher("/views/admin/product/productSale.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    ProductCommand command = FormUtil.populate(ProductCommand.class, req);
    if (command.getIdDelete() != null) {
      ProductDTO productUpdate = STServiceUtil.getProductService().findById(command.getIdDelete());
      productUpdate.setSale(command.isSale());
      try {
        STServiceUtil.getProductService().productUpdate(productUpdate);
        resp.sendRedirect("/admin/product?message=updateSuccess");
        ;
      } catch (Exception exception) {
        resp.sendRedirect("/admin/product?message=Error");
        ;
      }

    }
  }
}
