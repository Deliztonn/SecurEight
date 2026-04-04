package com.schutele.Serverlet;

import java.io.IOException;
import java.util.List;

import com.schutele.DAO.TipoUsuarioDAO; // Importe o DAO que criamos
import com.schutele.DAO.UsuarioDAO;
import com.schutele.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adm/cadastrar")
public class ServletCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TipoUsuarioDAO tipoDao = new TipoUsuarioDAO();
		List<String> tiposUsuario = tipoDao.buscarTiposUsuario();

		request.setAttribute("tiposUsuario", tiposUsuario);

		request.getRequestDispatcher("/adm/CadastroADM.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String bloco = request.getParameter("bloco");
		String ap = request.getParameter("ap");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		String TipoUsuario = request.getParameter("funcao");

		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = new Usuario(matricula, nome, bloco, ap, senha, email, TipoUsuario);

		dao.cadastrarUsuario(u);

		response.sendRedirect(request.getContextPath() + "/adm/CadastroADM.jsp");

	}
}