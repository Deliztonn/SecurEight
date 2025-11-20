package com.schutele.Serverlet;

import java.io.IOException;
import java.util.List;

import com.schutele.DAO.CadastrarDAO;
import com.schutele.DAO.TipoUsuarioDAO; // Importe o DAO que criamos
import com.schutele.DAO.CadastrarAtributos; // Importe a Entidade
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastrar" )
public class ServletCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    // --- MÉTODO GET: Prepara a página de cadastro ---
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        TipoUsuarioDAO tipoDao = new TipoUsuarioDAO();
        List<String> tiposUsuario = tipoDao.buscarTiposUsuario();
        
        request.setAttribute("tiposUsuario", tiposUsuario);
        
        // Encaminha para a sua página JSP
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
    // ---------------------------------------------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String bloco = request.getParameter("bloco");
		String ap = request.getParameter("ap");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
        
        // CORREÇÃO: Captura o valor do dropdown usando o nome correto do campo no JSP ("funcao")
        String tipoUsuario = request.getParameter("funcao"); 

        CadastrarDAO dao = new CadastrarDAO();
        CadastrarAtributos u = new CadastrarAtributos();

        u.setNome(nome);
        u.setBloco(bloco);
        u.setAp(ap);
        u.setEmail(email);
        u.setSenha(senha);
        u.setTipoUsuario(tipoUsuario); // Define o novo atributo
        
        dao.cadastrarUsuario(u);        
        
        // Opcional: Redirecionar para uma página de sucesso
	}
}