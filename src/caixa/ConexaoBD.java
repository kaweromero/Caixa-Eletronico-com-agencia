package caixa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

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

		} catch (SQLException e) {
			// imprimeErro("Erro ao buscar uma pessoa", e.getMessage());
			return null;
		}

	}

	public void tranferir(int login1, int login2, int valor) {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();

		try {
			cliente1 = verificarLogin(login1);
			cliente2 = verificarLogin(login2);

			if (valor <= cliente1.getSaldo()) {

				int saldo = cliente1.getSaldo();
				int saldoTotal = saldo - valor;
				cliente1.setSaldo(saldoTotal);
				atualizarSaldo(cliente1);

				int saldo2 = cliente2.getSaldo();
				int saldoTotal2 = saldo2 + valor;
				cliente2.setSaldo(saldoTotal2);
				atualizarSaldo(cliente2);

				JOptionPane.showMessageDialog(null,
						"Transferencia feita com sucesso!");
				fechar();
			} else {
				JOptionPane.showMessageDialog(null,
						"Valor excede o saldo da conta!");
			}

		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(null,
							"Erro na tranferência! Verifique o login ou o valor da tranferência.");
			fechar();

		}

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

	public void atualizarSaldo(Cliente cliente) {

		conectar();
		String com = "UPDATE caixaeletronico SET saldo = '"
				+ cliente.getSaldo() + "' WHERE  login = '"
				+ cliente.getLogin() + "';";
		System.out.println("Atualizada!");
		try {
			comando.executeUpdate(com);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fechar();
		}
	}

	public ConexaoBD() {

	}

}
