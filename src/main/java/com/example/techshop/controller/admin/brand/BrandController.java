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
import java.util.List;

@WebServlet("/admin/brand")
public class BrandController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // Set UTF 8 page
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {

      BrandCommand command = FormUtil.populate(BrandCommand.class, req);
      List<BrandDTO> listBrand = STServiceUtil.getBrandService()
          .pagination(command.getPage(), command.getMaxPageItems(), "name", command.getValue());
      command.setTotalItems((STServiceUtil.getBrandService().countBrand("name", command.getValue())
          / command.getMaxPageItems()) + 1);
      checkMessage(req);
      req.setAttribute("brands", listBrand);
      req.setAttribute("pojo", command);
      RequestDispatcher dispatcher
          = this.getServletContext().getRequestDispatcher("/views/admin/brand/brandManager.jsp");
      dispatcher.forward(req, resp);
    } catch (Exception e) {
      resp.sendRedirect("/error");
    }
  }

  public void checkMessage(HttpServletRequest request) {
    String message = request.getParameter("message");
    if (message != null) {
      if (message.trim().equals("addSuccess")) {
        request.setAttribute("message", "Thêm thương hiệu thành công");
      } else if (message.trim().equals("updateSuccess")) {
        request.setAttribute("message", "Sửa thương hiệu thành công");
      } else if (message.trim().equals("delSuccess")) {
        request.setAttribute("message", "Xóa thương hiệu thành công");
      } else if (message.trim().equals("Error")) {
        request.setAttribute("message", "Xóa thương hiệu thành công");
      }
    }

  }
}
