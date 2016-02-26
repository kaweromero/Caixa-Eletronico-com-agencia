package Agencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import caixa.Cliente;

public class ConexaoBD {

	private final String URL = "jdbc:postgresql://localhost:5432/banco",
			NOME = "postgres", SENHA = "1234";
	private Connection con;
	private Statement comando;
	public Cliente cliente = new Cliente();

	public void conectar() {
		try {

			con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.POSTGRESQL);
			comando = con.createStatement();
			System.out.println("Conectado!");

		} catch (ClassNotFoundException e) {
			imprimeErro("Erro ao carregar o driver!!!", e.getMessage());
		} catch (SQLException e) {
			imprimeErro("Erro ao conectar", e.getMessage());
		}

	}

	public int cadastra(int login, int senha, int saldo, String nome) {
		conectar();
		int resposta = 0;

		try {

			String com = "INSERT INTO caixaeletronico(login,senha,saldo,nome) VALUES ('"
					+ login
					+ "','"
					+ senha
					+ "','"
					+ saldo
					+ "','"
					+ nome
					+ "');";

			System.out.println("Atualizada!");

			comando.executeUpdate(com);

		} catch (Exception e) {
			resposta = 1;
			JOptionPane.showMessageDialog(null, "Conta ja existente!");
			return resposta;

		} finally {
			fechar();
		}
		return resposta;

	}

	public int deposita(int login, int valor) {
		int retorno = 0;
		conectar();

		try {
			cliente = verificarLogin(login);
			System.out.println(cliente.getSaldo());
			int total = (cliente.getSaldo() + valor);
			conectar();

			String com = "UPDATE caixaeletronico SET saldo = '" + total
					+ "' WHERE  login = '" + login + "';";
			System.out.println("Atualizada!");
			comando.executeUpdate(com);
			retorno = 1;
			return retorno;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Conta não encontrada!");
		} finally {
			fechar();
		}
		return retorno;

	}

	private void imprimeErro(String msg, String msgErro) {
		JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
		System.err.println(msg);
		System.out.println(msgErro);
	}

	private void fechar() {
		try {
			comando.close();
			con.close();
			System.out.println("Conexão Fechada");
		} catch (SQLException e) {
			imprimeErro("Erro ao fechar conexão", e.getMessage());
		}
	}

	public Cliente verificarLogin(int login) {
		conectar();

		String sql = "SELECT * FROM caixaeletronico WHERE login='" + login
				+ "';";

		try {
			ResultSet rs = comando.executeQuery(sql);
			if (rs.equals(null)) {
				return null;
			}
			rs.next();
			Cliente temp = new Cliente();
			temp.setLogin(rs.getInt("login"));
			temp.setSenha(rs.getInt("senha"));
			temp.setSaldo(rs.getInt("saldo"));
			temp.setNome(rs.getString("nome"));

			fechar();
			return temp;

		} catch (Exception e) {
			// imprimeErro("Erro ao buscar uma pessoa", e.getMessage());
			return null;
		}

	}

}
