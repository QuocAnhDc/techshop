package com.example.techshop.controller.admin.brand;


import com.example.techshop.command.BrandCommand;
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

@WebServlet("/admin/brand/delete")
public class BrandDeleteController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {
      BrandCommand command = FormUtil.populate(BrandCommand.class, req);
      if (command.getIdDelete() != null) {
        List ids = new ArrayList();
        ids.add(command.getIdDelete());
        STServiceUtil.getBrandService().delete(ids);
        resp.sendRedirect("/admin/brand?message=delSuccess");
      } else {
        resp.sendRedirect("/admin/brand");
      }
    } catch (Exception e) {
      resp.sendRedirect("/error");
    }
  }
}
