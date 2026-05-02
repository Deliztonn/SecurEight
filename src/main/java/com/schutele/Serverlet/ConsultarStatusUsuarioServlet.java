package com.schutele.Serverlet;

import java.io.IOException;

import com.schutele.DAO.UsuarioDAO;
import com.schutele.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ConsultarStatusUsuarioServlet")
public class ConsultarStatusUsuarioServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricula = req.getParameter("matricula");
		resp.setContentType("application/json");

		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = dao.buscarPorMatricula(matricula);

		boolean bloqueado = (u != null) && u.isBloqueado();
		resp.getWriter().write("{\"bloqueado\":" + bloqueado + "}");
	}
}
