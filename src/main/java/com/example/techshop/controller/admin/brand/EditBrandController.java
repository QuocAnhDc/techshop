package com.example.techshop.controller.admin.brand;

import com.example.techshop.command.BrandCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/brand/edit")
public class EditBrandController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {
      BrandCommand command = FormUtil.populate(BrandCommand.class, req);
      if (req.getParameter("brandId") != null) {
        Integer id = Integer.valueOf(req.getParameter("brandId"));
        BrandDTO dto = STServiceUtil.getBrandService().findEqualUnique("id", id);
        req.setAttribute("brand", dto);
      }

      RequestDispatcher dispatcher
          = this.getServletContext().getRequestDispatcher("/views/admin/brand/editBrand.jsp");
      dispatcher.forward(req, resp);
    } catch (Exception e) {
      resp.sendRedirect("/error");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {
      BrandCommand command = FormUtil.populate(BrandCommand.class, req);
      if (command.getPojo().getBrandId() != null) {
        STServiceUtil.getBrandService().update(command.getPojo());
        resp.sendRedirect("/admin/brand?message=updateSuccess");
      } else {
        STServiceUtil.getBrandService().save(command.getPojo());
        resp.sendRedirect("/admin/brand?message=addSuccess");
      }
    } catch (Exception e) {
      resp.sendRedirect("/error");
    }

  }
}
