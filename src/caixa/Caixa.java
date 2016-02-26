package caixa;

import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Agencia.FormataTexto;

public class Caixa {

	ImageIcon botao2 = new ImageIcon("imagem/botaopress.png");
	ImageIcon botaopressvirado = new ImageIcon("imagem/botaopressvirado.png");

	JLabel spritebotaocontacorrente = new JLabel(new ImageIcon("imagem/spritecontacorrente.png"));

	JLabel spritebotaoentrar = new JLabel(new ImageIcon("imagem/spriteentrar.png"));
	JLabel spritetransferir = new JLabel(new ImageIcon("imagem/spritetransferir.png"));
	JLabel spritetransferencia = new JLabel(new ImageIcon("imagem/spritetransferencia.png"));
	JLabel spritesaque = new JLabel(new ImageIcon("imagem/spritesaque.png"));
	JLabel spritesaldo = new JLabel(new ImageIcon("imagem/spritesaldo.png"));
	JLabel spritesair = new JLabel(new ImageIcon("imagem/spritesair.png"));
	JLabel spriteinformacao = new JLabel(new ImageIcon("imagem/spriteinformacao.png"));

	JLabel painelprincipal = new JLabel(new ImageIcon("imagem/tela.png"));
	JLabel telapainelinicio = new JLabel(new ImageIcon("imagem/telainicio.png"));
	JLabel telapainelapresentacao = new JLabel(new ImageIcon("imagem/telaapresentacao.png"));
	JLabel telapainellogin = new JLabel(new ImageIcon("imagem/painellogin.png"));
	JLabel telapaineltransicao = new JLabel(new ImageIcon("imagem/telatransicao.png"));
	JLabel telapainelcontacorrente = new JLabel(new ImageIcon("imagem/telacontacorrente.png"));
	JLabel telapainelsaque = new JLabel(new ImageIcon("imagem/telasaque.png"));
	JLabel telaPainelTransferencia = new JLabel(new ImageIcon("imagem/telatransferencia.png"));

	JLabel telapainelsaldo = new JLabel(new ImageIcon("imagem/telasaldo.png"));

	JTextField textLogin = new JTextField(20);
	JTextField textsaldo = new JTextField(20);
	JTextField textnome = new JTextField(20);
	JTextField textsaque = new JTextField(20);

	JTextField textLogin1 = new JTextField(20);
	JTextField textLogin2 = new JTextField(20);
	JTextField textValor = new JTextField(20);

	JPasswordField textSenha = new JPasswordField(20);

	public void telaInicial(JFrame frame) {

		apresentacao(frame);

		transicao(frame);

		telapainelinicio.setBounds(132, 93, 539, 439);

		spritebotaocontacorrente.setBounds(8, 265, 175, 49);

		telapainelinicio.add(spritebotaocontacorrente);

		telapainelinicio.setVisible(true);
		frame.add(telapainelinicio);

	}

	public void telaInicial2(JFrame frame) {

		telapainelcontacorrente.setVisible(false);
		telapainellogin.setVisible(false);
		telapainelinicio.setVisible(true);

		telapainelinicio.setBounds(132, 93, 539, 439);

		spritebotaocontacorrente.setBounds(8, 265, 175, 49);

		telapainelinicio.add(spritebotaocontacorrente);

		frame.add(telapainelinicio);

	}

	public void logincontaCorrente(JFrame frame) {

		telapainelinicio.setVisible(false);
		telapainellogin.setVisible(true);

		telapainellogin.setLayout(null);
		telapainellogin.setBounds(132, 93, 539, 439);

		spritesair.setBounds(375, 370, 160, 48);
		spritebotaoentrar.setBounds(375, 213, 160, 49);

		textLogin.setDocument(new FormataTexto(4, 'D'));
		textSenha.setDocument(new FormataTexto(10, 'D'));

		textLogin.setBounds(150, 220, 220, 40);
		textSenha.setBounds(150, 360, 220, 40);

		telapainellogin.add(textLogin);
		telapainellogin.add(textSenha);
		telapainellogin.add(spritesair);

		telapainellogin.add(spritebotaoentrar);

		frame.add(telapainellogin);

	}

	public void telacontacorrente(JFrame frame) {

		telapainellogin.setVisible(false);
		telapainelsaldo.setVisible(false);
		telapainelsaque.setVisible(false);
		telaPainelTransferencia.setVisible(false);

		telapainelcontacorrente.setVisible(true);
		telapainelcontacorrente.setLayout(null);

		textnome.setBounds(190, 170, 160, 20);
		textnome.setEditable(false);
		textnome.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textnome.setBackground(Color.lightGray);
		textnome.setBorder(null);

		telapainelcontacorrente.setBounds(132, 93, 539, 439);

		spritesaldo.setBounds(8, 211, 175, 48);
		spritetransferir.setBounds(8, 315, 175, 48);
		spritesair.setBounds(8, 370, 175, 48);
		spritesaque.setBounds(360, 213, 175, 48);
		spriteinformacao.setBounds(360, 370, 175, 48);

		telapainelcontacorrente.add(textnome);
		telapainelcontacorrente.add(spritesaldo);
		telapainelcontacorrente.add(spritetransferir);
		telapainelcontacorrente.add(spritesair);
		telapainelcontacorrente.add(spritesaque);
		telapainelcontacorrente.add(spriteinformacao);

		frame.add(telapainelcontacorrente);

	}

	public void telaTransferencia(JFrame frame) {

		telapainelcontacorrente.setVisible(false);
		telaPainelTransferencia.setVisible(true);

		telaPainelTransferencia.setLayout(null);
		telaPainelTransferencia.setBounds(132, 93, 539, 439);

		textLogin1.setBounds(180, 210, 190, 30);
		textLogin2.setBounds(180, 290, 190, 30);
		textValor.setBounds(180, 360, 190, 30);
		spritesair.setBounds(8, 370, 165, 48);
		spritetransferencia.setBounds(8, 200, 165, 48);

		textLogin1.setDocument(new FormataTexto(4, 'D'));
		textLogin2.setDocument(new FormataTexto(4, 'D'));
		textValor.setDocument(new FormataTexto(3, 'D'));

		telaPainelTransferencia.add(textLogin1);
		telaPainelTransferencia.add(textLogin2);
		telaPainelTransferencia.add(textValor);
		telaPainelTransferencia.add(spritesair);
		telaPainelTransferencia.add(spritetransferencia);

		frame.add(telaPainelTransferencia);

	}

	public void telasaldo(JFrame frame) {

		telapainelcontacorrente.setVisible(false);
		telapainelsaldo.setVisible(true);

		telapainelsaldo.setLayout(null);
		telapainelsaldo.setBounds(132, 93, 539, 439);

		textsaldo.setBounds(160, 220, 220, 40);
		spritesair.setBounds(8, 370, 175, 48);
		telapainelsaldo.add(textsaldo);
		telapainelsaldo.add(spritesair);

		textsaldo.setEditable(false);

		frame.add(telapainelsaldo);

	}

	public void telasaque(JFrame frame) {

		telapainelcontacorrente.setVisible(false);

		telapainelsaque.setVisible(true);
		telapainelsaque.setLayout(null);

		telapainelsaque.setBounds(132, 93, 539, 439);

		textsaque.setBounds(160, 290, 220, 40);
		spritesaque.setBounds(8, 214, 175, 48);
		spritesair.setBounds(8, 370, 175, 48);

		textsaque.setDocument(new FormataTexto(3, 'D'));

		telapainelsaque.add(textsaque);
		telapainelsaque.add(spritesair);
		telapainelsaque.add(spritesaque);
		frame.add(telapainelsaque);

	}

	public void apresentacao(JFrame frame) {

		telapainelapresentacao.setBounds(132, 93, 539, 439);
		frame.add(telapainelapresentacao);

		delay(0);

		telapainelapresentacao.setVisible(false);
		telapainelinicio.setLayout(null);

	}

	public void transicao(JFrame frame) {

		telapaineltransicao.setVisible(true);
		telapaineltransicao.setBounds(132, 93, 539, 439);
		frame.add(telapaineltransicao);

		delay(0);

		telapaineltransicao.setVisible(false);

	}

	public void colocarsaldo(String saldo) {
		textsaldo.setText("R$:" + saldo);
	}

	public void colocarnome(String nome) {
		textnome.setText(nome);
	}

	public String pegarSaldo() {

		String str = textsaque.getText();
		return str;
	}

	public String pegarLogin1() {

		String str = textLogin1.getText();
		return str;
	}

	public String pegarLogin2() {

		String str = textLogin2.getText();
		return str;
	}

	public String pegarValor() {

		String str = textValor.getText();
		return str;
	}

	public int pegarLogin() {

		int login = 0;
		login = Integer.parseInt(textLogin.getText());

		return login;
	}

	@SuppressWarnings("deprecation")
	public int pegarSenha() {

		int senha = 0;
		senha = Integer.parseInt(textSenha.getText());

		return senha;
	}

	public void limparcampos() {
		textLogin.setText("");
		textSenha.setText("");
	}

	public void limparTransf() {
		textLogin1.setText("");
		textLogin2.setText("");
		textValor.setText("");
	}

	public void limparsaque() {
		textsaque.setText("");

	}

	public void delay(int segundos) {

		try {
			TimeUnit.SECONDS.sleep(segundos);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
