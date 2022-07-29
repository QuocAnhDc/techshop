package com.example.techshop.controller.login;

import com.example.techshop.command.UserCommand;
import com.example.techshop.common.CoreConstant;
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

@WebServlet("/register")
public class RegisterController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher
        = request.getRequestDispatcher("/views/common/register.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    UserCommand command = FormUtil.populate(UserCommand.class, request);
    UserDTO user = command.getPojo();

    try {
      user.setRoleDTO(STServiceUtil.getRoleService().getRoleByName("CUSTOMER"));
      boolean checkUniqueEmail = STServiceUtil.getUserService().register(user);
      if (!checkUniqueEmail) {
        request.setAttribute("isNotUniqueNotification", CoreConstant.USER_IS_NOT_UNIQUE);
        RequestDispatcher dispatcher
            = request.getRequestDispatcher("/views/common/register.jsp");
        dispatcher.forward(request, response);
      } else {
        request.setAttribute("successfulRegister", CoreConstant.SUCCESSFUL_REGISTER);
        RequestDispatcher dispatcher
            = request.getRequestDispatcher("/views/common/register.jsp");
        dispatcher.forward(request, response);
      }
    } catch (Exception e) {
      response.sendRedirect("/error");
    }

  }
}
