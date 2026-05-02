
package com.schutele.Serverlet;

import com.schutele.DAO.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/historico")
public class ServletHistorico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DateTimeFormatter HORA_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
	private static final DateTimeFormatter DATA_FORMATTER = DateTimeFormatter.ofPattern("dd/MM");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String[]> historicoFormatado = new ArrayList<>();
		System.out.println("Entrou no servlet historico!");

		String sql = "SELECT acao, data_leitura FROM registros ORDER BY data_leitura DESC";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String acao = rs.getString("acao");
				Timestamp ts = rs.getTimestamp("data_leitura");

				if (ts != null) {
					LocalDateTime dataHora = ts.toLocalDateTime();
					String horario = dataHora.format(HORA_FORMATTER);
					String diaMes = dataHora.format(DATA_FORMATTER);
					historicoFormatado.add(new String[] { acao, horario, diaMes });
				}
			}

			System.out.println("Historico carregado: " + historicoFormatado.size() + " registros");

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao carregar histórico: " + e.getMessage());
		}

		request.setAttribute("historicoAcesso", historicoFormatado);
		
		// Ajuste do caminho caso esteja dentro da pasta /adm/
		request.getRequestDispatcher("/adm/historico.jsp").forward(request, response);
	}
}
