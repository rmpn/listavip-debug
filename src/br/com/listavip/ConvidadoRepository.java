package br.com.listavip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;

public class ConvidadoRepository {

	Connection conexao = null;

	public List<Convidado> obterTodos() {

		try {

			conexao = DB.obterConexao();
			//conexao = DB.getConnection();

			String select = "select * from convidado";

			PreparedStatement preparedStatement = conexao.prepareStatement(select);

			ResultSet rs = preparedStatement.executeQuery();

			List<Convidado> listaDeConvidados = new ArrayList<>();

			while (rs.next()) {

				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");

				Convidado convidado = new Convidado(id, nome, email, telefone);
				listaDeConvidados.add(convidado);

			}

			return listaDeConvidados;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				conexao.close();
			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}

		}

		return null;
	}

	public void salvar(Convidado convidado) {

		try {

			// Connection conexao = new FabricaDeConexao().obterConexao();
			// conexao = DB.getConnection();
			conexao = DB.obterConexao();

			String insert = "INSERT INTO convidado(nome, email, telefone) VALUES(?, ?, ?);";

			PreparedStatement preparedStatement = conexao.prepareStatement(insert);
			preparedStatement.setString(1, convidado.getNome());
			preparedStatement.setString(2, convidado.getEmail());
			preparedStatement.setString(3, convidado.getTelefone());

			preparedStatement.execute();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			try {
				conexao.close();

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}

		}

	}

}
