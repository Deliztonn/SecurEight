package com.schutele.Serverlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({ "/logout" })
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogout() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("Login.jsp");
	}
}
