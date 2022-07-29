package com.example.techshop.controller.admin.category;


import com.example.techshop.command.CategoryCommand;
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

@WebServlet("/admin/category/delete")
public class CategoryDeleteController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {
      CategoryCommand command = FormUtil.populate(CategoryCommand.class, req);
      if (command.getIdDelete() != null) {
        List ids = new ArrayList();
        ids.add(command.getIdDelete());
        STServiceUtil.getCategoryService().delete(ids);
        resp.sendRedirect("/admin/category?message=delSuccess");
      } else {
        resp.sendRedirect("/admin/category");
      }
    } catch (Exception e) {
      resp.sendRedirect("/error");
    }

  }
}
