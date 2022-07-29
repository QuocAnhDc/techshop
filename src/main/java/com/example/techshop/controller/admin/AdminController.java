package com.example.techshop.controller.admin;


import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      // get data from page
      OrderDetailCommand command = FormUtil.populate(OrderDetailCommand.class, request);
      List<Integer> years = STServiceUtil.getOrderDetailService().getYear();

      // get year now
      if (command.getYear() == null) {
        LocalDate current_date = LocalDate.now();
        Integer year = current_date.getYear();
        command.setYear(year);
      }
      // get income every year
      Map<Integer, Integer> data = STServiceUtil.getOrderDetailService()
          .getIncomeInMonth(command.getYear());
      Integer countOrder = STServiceUtil.getOrderDetailService().CountOrderDetailNotConFirmed();
      Integer countCart = STServiceUtil.getCartItemService().countCartItemsGreater30Day();

      //send data to page
      request.setAttribute("countCart", countCart);
      request.setAttribute("countOrder", countOrder);
      setData(request,data);
      request.setAttribute("years", years);
      request.setAttribute("pojo", command);

      RequestDispatcher dispatcher
          = this.getServletContext().getRequestDispatcher("/views/admin/admin.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }

  private void setData(HttpServletRequest request, Map<Integer, Integer> data) {
    request.setAttribute("January", data.get(1));
    request.setAttribute("February", data.get(2));
    request.setAttribute("March", data.get(3));
    request.setAttribute("April", data.get(4));
    request.setAttribute("May", data.get(5));
    request.setAttribute("June", data.get(6));
    request.setAttribute("July", data.get(7));
    request.setAttribute("August", data.get(8));
    request.setAttribute("September", data.get(9));
    request.setAttribute("October", data.get(10));
    request.setAttribute("November", data.get(11));
    request.setAttribute("December", data.get(12));

  }
}