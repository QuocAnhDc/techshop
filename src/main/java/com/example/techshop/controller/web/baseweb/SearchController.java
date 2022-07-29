package com.example.techshop.controller.web.baseweb;

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
import java.util.List;
import java.util.Map;

@WebServlet("/search")
public class SearchController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      CategoryCommand categoryCommand = FormUtil.populate(CategoryCommand.class, request);
      ProductCommand productCommand = FormUtil.populate(ProductCommand.class, request);
      setCommandAttribute(categoryCommand, productCommand, request);

      RequestDispatcher dispatcher
          = request.getServletContext().getRequestDispatcher("/views/web/baseweb/searchResult.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }

  void setCommandAttribute(CategoryCommand categoryCommand,
      ProductCommand productCommand,
      HttpServletRequest request) {
    productCommand.setFirstIndex(0);
    categoryCommand.setListResult(STServiceUtil.getCategoryService().getAllCategory());
    categoryCommand.setBrandInCate(
        STServiceUtil.getCategoryService().buildBrandInCate(categoryCommand.getListResult()));

    Map<String, Object> properties = STServiceUtil.getProductService()
        .searchProperties(productCommand);

    List<ProductDTO> products = (List<ProductDTO>) STServiceUtil.getProductService()
        .getProducts(properties)[0];

    productCommand.setListResult(products);

    productCommand.setTotalItems(
        (Integer) STServiceUtil.getProductService().getProducts(properties)[1]);
    productCommand.setTotalPages(totalPages(productCommand));

    if (productCommand.getBrand().getBrandId()!=null && productCommand.getCategory().getCategoryId()!=null){
      productCommand.setBrand(STServiceUtil.getBrandService().findById(productCommand.getBrand().getBrandId()));
      productCommand.setCategory(STServiceUtil.getCategoryService().findById(productCommand.getCategory().getCategoryId()));
    }

    request.setAttribute("cateItems", categoryCommand);
    request.setAttribute("productItems", productCommand);
  }

  int totalPages(ProductCommand command) {
    int totalItems = command.getTotalItems();
    int maxPageItems = command.getMaxPageItems();
    return totalItems % maxPageItems == 0 ? totalItems / maxPageItems
        : totalItems / maxPageItems + 1;
  }

}
