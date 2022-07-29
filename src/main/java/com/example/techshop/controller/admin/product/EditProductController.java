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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/admin/product/edit")
public class EditProductController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    try {
      //get data from page
      ProductCommand command = FormUtil.populate(ProductCommand.class, request);
      // check update or create product
      if (request.getParameter("productId") != null) {
        Integer id = Integer.valueOf(request.getParameter("productId"));
        ProductDTO dto = STServiceUtil.getProductService().findEqualUnique("id", id);
        request.setAttribute("product", dto);
      }
      // get list brand and category
      List<BrandDTO> listBrand = STServiceUtil.getBrandService().getAllBrand();
      List<CategoryDTO> listCategory = STServiceUtil.getCategoryService().getAllCategory();

      //send data to page
      request.setAttribute("brands", listBrand);
      request.setAttribute("categorys", listCategory);
      RequestDispatcher dispatcher
          = this.getServletContext().getRequestDispatcher("/views/admin/product/editProduct.jsp");
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
    //get data
    ProductCommand command = FormUtil.populate(ProductCommand.class, req);
    Integer idCategory = Integer.valueOf(command.getCategoryDTO());
    Integer idBrand = Integer.valueOf(command.getBrandDTO());

    //update
    if (command.getPojo().getProductId() != null) {
      ProductDTO productUpdate = command.getPojo();
      if(productUpdate.getPhoto() ==null || productUpdate.getPhoto().equals("")) {
       productUpdate.setPhoto(STServiceUtil.getProductService().findById(productUpdate.getProductId()).getPhoto());
      }
      productUpdate.setCategoryDTO(STServiceUtil.getCategoryService().findById(idCategory));
      productUpdate.setBrandDTO(STServiceUtil.getBrandService().findById(idBrand));
      try {
        STServiceUtil.getProductService().productUpdate(productUpdate);
        resp.sendRedirect("/admin/product?message=updateSuccess");
      } catch (Exception exception) {
        resp.sendRedirect("/admin/product?message=Error");
      }

      //create product
    } else {
      ProductDTO dto = command.getPojo();
      dto.setCategoryDTO(STServiceUtil.getCategoryService().findById(idCategory));
      dto.setBrandDTO(STServiceUtil.getBrandService().findById(idBrand));
      dto.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
      try {
        STServiceUtil.getProductService().save(dto);
        resp.sendRedirect("/admin/product?message=addSuccess");
      } catch (Exception exception) {
        resp.sendRedirect("/admin/product?message=Error");
      }

    }

  }
}

