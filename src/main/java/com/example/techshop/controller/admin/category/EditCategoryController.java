package com.example.techshop.controller.admin.category;


import com.example.techshop.command.CategoryCommand;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/category/edit")
public class EditCategoryController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {
      CategoryCommand command = FormUtil.populate(CategoryCommand.class, req);
      if (req.getParameter("categoryId") != null) {
        Integer id = Integer.valueOf(req.getParameter("categoryId"));
        CategoryDTO dto = STServiceUtil.getCategoryService().findEqualUnique("id", id);
        req.setAttribute("category", dto);
      }

      RequestDispatcher dispatcher
          = this.getServletContext().getRequestDispatcher("/views/admin/category/editCategory.jsp");
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
    CategoryCommand command = FormUtil.populate(CategoryCommand.class, req);
    if (command.getPojo().getCategoryId() != null) {
      try {
        STServiceUtil.getCategoryService().update(command.getPojo());
        resp.sendRedirect("/admin/category?message=updateSuccess");
      } catch (Exception exception) {
        resp.sendRedirect("/admin/category?message=Error");
      }

    } else {
      try {
        STServiceUtil.getCategoryService().save(command.getPojo());
        resp.sendRedirect("/admin/category?message=addSuccess");
      } catch (Exception exception) {
        resp.sendRedirect("/admin/category?message=Error");
      }

    }
  }
}
