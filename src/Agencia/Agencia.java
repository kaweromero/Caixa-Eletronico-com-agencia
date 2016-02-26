package Agencia;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Agencia extends JFrame {

	JLabel tela = new JLabel(new ImageIcon(getClass().getResource(
			"/Agencia.png")));
	int login;
	int senha;
	int saldo;
	int valordeposito;
	String nome;
	ConexaoBD conexaoBD = new ConexaoBD();
	int respostaInicio;

	public Agencia() {

		setSize(800, 600);
		setResizable(false);
		setLayout(null);
		setFocusable(true);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("iconenovo.png")));
		setTitle("Agência bancária!");
		tela.setBounds(0, 0, 800, 600);
		add(tela);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		inicio();

	}

	public void inicio() {
		JOptionPane.showMessageDialog(null, "Seja bem vindo a agência do BD!");

		respostaInicio = JOptionPane.showConfirmDialog(null,
				"Deseja criar uma nova conta? ");

		if (respostaInicio == JOptionPane.YES_OPTION) {
			cria();
		}

		if (respostaInicio == JOptionPane.NO_OPTION) {
			int respostaInicio2;

			respostaInicio2 = JOptionPane.showConfirmDialog(null,
					"Deseja fazer um deposito? ");

			if (respostaInicio2 == JOptionPane.YES_OPTION) {
				deposita();

			}
			if (respostaInicio2 == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
			if (respostaInicio2 == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}

		}
		if (respostaInicio == JOptionPane.CANCEL_OPTION) {
			System.exit(0);
		}
	}

	public void cria() {

		int resposta;
		int retorno;

		try {
			login = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o login da conta:"));

			senha = Integer.parseInt(JOptionPane
					.showInputDialog("Digite a senha da conta"));

			saldo = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o valor do saldo:"));

			nome = JOptionPane.showInputDialog("Digite seu nome (1° e 2°):");

			retorno = conexaoBD.cadastra(login, senha, saldo, nome);

			if (retorno == 0) {
				JOptionPane.showMessageDialog(null,
						"Conta criada com sucesso! \n Pega o beco!");
				System.exit(0);
			}
			if (retorno == 1) {
				cria();
			}

		} catch (Exception e) {

			resposta = JOptionPane.showConfirmDialog(null,
					"Digite corretamente os campos!\n Deseja continuar?");

			if (resposta == JOptionPane.YES_OPTION) {
				cria();
			}
			if (resposta == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
			if (resposta == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}

		}

	}

	public void deposita() {
		int retorno;

		login = Integer.parseInt(JOptionPane
				.showInputDialog("Digite o login da conta: "));

		valordeposito = Integer.parseInt(JOptionPane
				.showInputDialog("Digite o valor do deposito: "));

		retorno = conexaoBD.deposita(login, valordeposito);
		if (retorno == 0) {
			inicio();
		}
		if (retorno == 1) {
			JOptionPane.showMessageDialog(null,
					"Obrigado por escolher nosso banco!");
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Agencia();
	}

}
