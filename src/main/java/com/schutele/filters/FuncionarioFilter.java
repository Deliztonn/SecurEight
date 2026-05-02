package com.schutele.filters;

import com.schutele.model.Usuario;  // ← IMPORT CORRETO
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/adm/*"})
public class FuncionarioFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");

        if (usuario != null && "adm".equalsIgnoreCase(usuario.getTipoUsuario())) {
            chain.doFilter(request, response);
        } else if (usuario == null) {
            resp.sendRedirect("Login.jsp");
        } else {
            resp.sendRedirect("acesso-negado.jsp");
        }
    }
}
