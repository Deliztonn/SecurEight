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

@WebServlet("/login" )
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Pegar dados do formulário
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // 2. Validar login no banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.validarLogin(email, senha);

        // 3. Se encontrou o usuário
        if (usuario != null) {

            // Criar sessão
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario.getNome());
            session.setAttribute("tipoUsuario", usuario.getTipo()); // ADM ou USER

            // 4. Redirecionamento por tipo de usuário
            // O tipo lido do banco (ex: "adm" ou "usuario") é comparado aqui
            if (usuario.getTipo().equalsIgnoreCase("adm")) {
                response.sendRedirect("MenuA.jsp");
            } else {
                response.sendRedirect("MenuU.jsp");
            }

        } else {
            // Login inválido → volta para o login com alerta
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script>");
            response.getWriter().println("alert('Email ou senha inválidos. Tente novamente.');");
            response.getWriter().println("window.location.href = 'Login.jsp';");
            response.getWriter().println("</script>");
        }
    }
}
