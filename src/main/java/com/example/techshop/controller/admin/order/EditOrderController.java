package com.example.techshop.controller.admin.order;


import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/order/edit")
public class EditOrderController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {
      OrderDetailCommand command = FormUtil.populate(OrderDetailCommand.class, req);
      OrderDetailDTO dto = STServiceUtil.getOrderDetailService()
          .findById(command.getPojo().getOrderDetailId());
      dto.setIspaid(command.getIsPaid());
      STServiceUtil.getOrderDetailService().update(dto);
      if (dto.getIspaid()) {
        STServiceUtil.getOrderDetailService().sendConfirmationMail(dto);
      }
      resp.sendRedirect("/admin/order?page=" + command.getPage() + "&value=" + command.getValue());
    } catch (Exception e) {
      resp.sendRedirect("/error");
    }

  }
}
