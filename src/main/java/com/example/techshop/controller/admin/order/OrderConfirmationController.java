package com.example.techshop.controller.admin.order;


import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.dto.OrderDetailDTO;
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

@WebServlet("/admin/order/confirm")
public class OrderConfirmationController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    try {
      OrderDetailCommand command = FormUtil.populate(OrderDetailCommand.class, req);
      List<OrderDetailDTO> listOrder = STServiceUtil.getOrderDetailService()
          .pagingnation(command.getPage(), command.getMaxPageItems(), false);
      command.setTotalItems((STServiceUtil.getOrderDetailService().CountOrderDetailList(false)
          / command.getMaxPageItems()) + 1);
      for (OrderDetailDTO order : listOrder) {
        order.setOrderItemDTOList(
            STServiceUtil.getOrderItemService().findByOrderDetail(order.getOrderDetailId()));
      }

      req.setAttribute("orders", listOrder);
      req.setAttribute("pojo", command);

      RequestDispatcher dispatcher
          = this.getServletContext().getRequestDispatcher("/views/admin/order/orderConfirm.jsp");
      dispatcher.forward(req, resp);
    } catch (Exception e) {
      resp.sendRedirect("/error");
    }
  }
}
