package com.schutele.Serverlet;

import java.io.IOException;
import java.util.List;
import com.schutele.DAO.AvisoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aviso")
public class ServletAvisos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AvisoDAO avisoDAO = new AvisoDAO();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensagem = request.getParameter("mensagem");

		if (mensagem != null && !mensagem.trim().isEmpty()) {
			avisoDAO.inserirAviso(mensagem);
		}
		response.sendRedirect(request.getContextPath() + "/aviso");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> avisos = avisoDAO.listarAvisos();

		request.setAttribute("avisos", avisos);
		request.getRequestDispatcher("/adm/AvisosADM.jsp").forward(request, response);
		System.out.println("Avisos carregados: " + avisos.size());
	}
}