package com.example.techshop.controller.login;

import com.example.techshop.common.CoreConstant;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.AppUtils;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public LoginController() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RequestDispatcher dispatcher //
        = request.getServletContext().getRequestDispatcher("/views/common/login.jsp");

    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    UserDTO userAccount = STServiceUtil.getUserService().findUser(email, password);

    if (userAccount == null) {
      request.setAttribute("errorMessage", CoreConstant.LOGIN_ERROR);
      RequestDispatcher dispatcher = request.getServletContext()
          .getRequestDispatcher("/views/common/login.jsp");
      dispatcher.forward(request, response);
      return;
    }

    AppUtils.storeLoginedUser(request.getSession(), userAccount);

    //
    int redirectId = -1;
    try {
      redirectId = Integer.parseInt(request.getParameter("redirectId"));
    } catch (Exception e) {
    }
    String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
    if (requestUri != null) {
      response.sendRedirect(requestUri);
    } else {
      response.sendRedirect("/home");
    }
  }
}
