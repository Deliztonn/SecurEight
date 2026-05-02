package com.schutele.Serverlet;

import java.io.IOException;

import com.schutele.DAO.UsuarioDAO;
import com.schutele.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({ "/login" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuario = dao.validarLogin(email, senha);

		if (usuario == null) {
			System.out.println("USUARIO NULO");
			request.setAttribute("erro", "Usuário ou senha incorretos!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("usuarioLogado", usuario);

		System.out.println("Login realizado → " + usuario.getNome());
		System.out.println("Tipo de usuário → " + usuario.getTipoUsuario());

		if ("adm".equalsIgnoreCase(usuario.getTipoUsuario())) {
			response.sendRedirect(request.getContextPath() + "/adm/MenuADM.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/usuario/MenuUser.jsp");
		}

	}
}
