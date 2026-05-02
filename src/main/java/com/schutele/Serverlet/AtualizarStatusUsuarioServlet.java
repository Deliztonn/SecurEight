package com.schutele.Serverlet;

import java.io.IOException;

import com.schutele.DAO.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AtualizarStatusUsuarioServlet")
public class AtualizarStatusUsuarioServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricula = req.getParameter("matricula");
		String acao = req.getParameter("acao");

		boolean bloquear = "bloquear".equals(acao);

		UsuarioDAO dao = new UsuarioDAO();
		dao.atualizarStatus(matricula, bloquear);

		resp.sendRedirect("editarChave.jsp");
	}
}