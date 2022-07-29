package com.example.techshop.controller.web.customer;

import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.OrderItemDTO;
import com.example.techshop.dto.UserDTO;
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

@WebServlet("/done-order")
public class DoneOrderController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    OrderDetailCommand orderDetailCommand = FormUtil.populate(OrderDetailCommand.class, request);
    try {
      UserDTO cus = (UserDTO) request.getSession().getAttribute("loginedUser");
      Map<OrderDetailDTO, List<OrderItemDTO>> itemsByCus = STServiceUtil.getOrderDetailService()
          .getItemsByCus(cus.getUserId());
      orderDetailCommand.setItemsByCus(itemsByCus);
      request.setAttribute("orderDetails",orderDetailCommand);
      RequestDispatcher dispatcher
          = request.getServletContext().getRequestDispatcher("/views/web/customer/doneOrder.jsp");
      dispatcher.forward(request, response);
    }catch (Exception e){
      response.sendRedirect("/error");
    }
  }
}
