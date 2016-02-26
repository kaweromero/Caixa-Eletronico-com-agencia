package caixa;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InterfaceCaixa extends JFrame {

	ImageIcon botao2 = new ImageIcon(getClass().getResource("/botaopress.png"));
	ImageIcon botaopressvirado = new ImageIcon(getClass().getClassLoader().getResource("botaopressvirado.png"));

	JLabel painelprincipal = new JLabel(new ImageIcon(getClass().getResource(
			"/tela.png")));
	JLabel telapainel2 = new JLabel(new ImageIcon(getClass().getClassLoader()
			.getResource("telainicio.png")));
	JLabel telapainel1 = new JLabel(new ImageIcon(getClass().getClassLoader()
			.getResource("telaapresentacao.png")));
	JLabel spritebotaocontacorrente = new JLabel(new ImageIcon(getClass()
			.getClassLoader().getResource("spritecontacorrente.png")));
	JLabel spritebotaopoupanca = new JLabel(new ImageIcon(getClass()
			.getClassLoader().getResource("spritepoupanca.png")));

	JButton botaoesquerda1 = new JButton(new ImageIcon(getClass()
			.getClassLoader().getResource("botao.png")));
	JButton botaoesquerda2 = new JButton(new ImageIcon(getClass()
			.getClassLoader().getResource("botao.png")));
	JButton botaoesquerda3 = new JButton(new ImageIcon(getClass()
			.getClassLoader().getResource("botao.png")));
	JButton botaoesquerda4 = new JButton(new ImageIcon(getClass()
			.getClassLoader().getResource("botao.png")));
	JButton botaodireita1 = new JButton(new ImageIcon(getClass()
			.getClassLoader().getResource("botaovirado.png")));
	JButton botaodireita2 = new JButton(new ImageIcon(getClass()
			.getClassLoader().getResource("botaovirado.png")));
	JButton botaodireita3 = new JButton(new ImageIcon(getClass()
			.getClassLoader().getResource("botaovirado.png")));
	JButton botaodireita4 = new JButton(new ImageIcon(getClass()
			.getClassLoader().getResource("botaovirado.png")));

	JFrame frame = new JFrame();
	Caixa caixa = new Caixa();
	ConexaoBD conexaoBD = new ConexaoBD();
	Cliente cliente = new Cliente();

	int saldoTotal = 0;
	String nomecliente = "";
	int login;
	int senha;

	boolean ativarbotaotelainicial = true;
	boolean ativarbotaologin = true;

	boolean saldo = true;
	boolean saque = true;
	boolean saircontacorrente = true;
	boolean informacao = true;
	boolean transferir = true;

	boolean botaotransferir = true;

	public InterfaceCaixa() {

		botaoesquerda1.setPressedIcon(botao2);
		botaoesquerda2.setPressedIcon(botao2);
		botaoesquerda3.setPressedIcon(botao2);
		botaoesquerda4.setPressedIcon(botao2);
		botaodireita1.setPressedIcon(botaopressvirado);
		botaodireita2.setPressedIcon(botaopressvirado);
		botaodireita3.setPressedIcon(botaopressvirado);
		botaodireita4.setPressedIcon(botaopressvirado);

		botaoesquerda1.setBorder(null);
		botaoesquerda2.setBorder(null);
		botaoesquerda3.setBorder(null);
		botaoesquerda4.setBorder(null);
		botaodireita1.setBorder(null);
		botaodireita2.setBorder(null);
		botaodireita3.setBorder(null);
		botaodireita4.setBorder(null);

		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(805, 610);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("iconenovo.png")));
		frame.setTitle("Caixa Eletronico");

		frame.add(painelprincipal);

		painelprincipal.add(botaoesquerda1);
		painelprincipal.add(botaoesquerda2);
		painelprincipal.add(botaoesquerda3);
		painelprincipal.add(botaoesquerda4);
		painelprincipal.add(botaodireita1);
		painelprincipal.add(botaodireita2);
		painelprincipal.add(botaodireita3);
		painelprincipal.add(botaodireita4);

		botaoesquerda1.setBounds(25, 295, 54, 40);
		botaoesquerda2.setBounds(23, 350, 54, 40);
		botaoesquerda3.setBounds(21, 404, 54, 40);
		botaoesquerda4.setBounds(20, 456, 54, 40);
		botaodireita1.setBounds(725, 295, 54, 40);
		botaodireita2.setBounds(725, 350, 54, 40);
		botaodireita3.setBounds(725, 404, 54, 40);
		botaodireita4.setBounds(727, 457, 54, 40);

		painelprincipal.setSize(800, 600);
		painelprincipal.setLocation(0, 0);

		frame.setVisible(true);

		ativarbotoestelainicial();
		caixa.telaInicial(frame);

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void ativarbotoestelainicial() {

		botaoesquerda1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {

					if (saldo == true && ativarbotaotelainicial == false
							&& ativarbotaologin == false) {
						// JOptionPane.showMessageDialog(null,"Opção escolhida: saldo!");
						caixa.telasaldo(frame);

						cliente = conexaoBD.verificarLogin(login);
						saldoTotal = cliente.getSaldo();
						caixa.colocarsaldo(Integer.toString(saldoTotal));

						saque = false;
						saircontacorrente = false;
						ativarbotaologin = false;

						informacao = false;
						transferir = false;
					}

				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Erro do saldo!");
				}

				try {

					if (botaotransferir == false && transferir == true) {

						int login1 = Integer.parseInt(caixa.pegarLogin1());
						int login2 = Integer.parseInt(caixa.pegarLogin2());
						int valor = Integer.parseInt(caixa.pegarValor());

						conexaoBD.tranferir(login1, login2, valor);
						caixa.limparTransf();

					}

				} catch (Exception ee) {
					JOptionPane
							.showMessageDialog(null,
									"Erro na tranferência! Verifique o login ou o valor da tranferência.");

				}

				try {

					if (saque == true && ativarbotaotelainicial == false
							&& ativarbotaologin == false) {

						int valorsaque = Integer.parseInt(caixa.pegarSaldo());

						if (saldoTotal >= valorsaque) {

							int novoValor = saldoTotal - valorsaque;

							cliente.setSaldo(novoValor);
							conexaoBD.atualizarSaldo(cliente);

							JOptionPane.showMessageDialog(null,
									"Saque efetuado com sucesso!");
							caixa.limparsaque();

						} else {
							JOptionPane.showMessageDialog(null,
									"Valor excede so seu saldo!");
						}

					}

				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null,
							"Erro de saque! Digite o valor corretamente!");

				}

			}
		});

		botaoesquerda2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (ativarbotaotelainicial == true) {
					// JOptionPane.showMessageDialog(null,"Opção escolhida: Conta corrente!");

					caixa.logincontaCorrente(frame);

					ativarbotaotelainicial = false;

				}

			}
		});

		botaoesquerda3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (transferir == true && ativarbotaotelainicial == false
						&& ativarbotaologin == false && botaotransferir == true) {
					// JOptionPane.showMessageDialog(null,"Opção escolhida: transferir!");
					caixa.telaTransferencia(frame);

					saque = false;
					saldo = false;
					saircontacorrente = false;
					ativarbotaologin = false;

					informacao = false;
					botaotransferir = false;

				}

			}
		});

		botaoesquerda4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (saircontacorrente == true
						&& ativarbotaotelainicial == false
						&& ativarbotaologin == false) {

					caixa.telaInicial2(frame);

					saircontacorrente = true;
					ativarbotaotelainicial = true;
					ativarbotaologin = true;

				}

				if (saldo == true && saircontacorrente == false) {

					caixa.telacontacorrente(frame);

					saque = true;
					saircontacorrente = true;
					informacao = true;
					transferir = true;
					caixa.limparsaque();
				}

				if (saque == true && saircontacorrente == false) {

					caixa.telacontacorrente(frame);

					saldo = true;
					saircontacorrente = true;
					informacao = true;
					transferir = true;
				}

				if (transferir == true && saircontacorrente == false) {

					caixa.telacontacorrente(frame);

					saque = true;
					saldo = true;
					saircontacorrente = true;
					informacao = true;
					botaotransferir = true;
				}

			}
		});

		botaodireita1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					if (ativarbotaotelainicial == false
							&& ativarbotaologin == true) {

						login = caixa.pegarLogin();
						senha = caixa.pegarSenha();

						cliente = conexaoBD.verificarLogin(caixa.pegarLogin());

						saldoTotal = cliente.getSaldo();
						caixa.colocarsaldo(Integer.toString(saldoTotal));

						nomecliente = cliente.getNome();
						caixa.colocarnome(nomecliente);

						if (login == cliente.getLogin()
								&& senha == cliente.getSenha()) {

							caixa.telacontacorrente(frame);
							caixa.limparcampos();
							ativarbotaologin = false;

						} else {
							JOptionPane.showMessageDialog(null,
									"Login ou senha não encontrada");
						}

					} else {

						if (saque == true && ativarbotaotelainicial == false
								&& ativarbotaologin == false) {

							caixa.telasaque(frame);

							saldo = false;
							saircontacorrente = false;
							ativarbotaologin = false;

							informacao = false;
							transferir = false;
						}

					}

				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null,
							"Insira o login e senha corretamente!");

				}

			}
		});

		botaodireita2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		botaodireita3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		botaodireita4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (informacao == true && ativarbotaotelainicial == false
						&& ativarbotaologin == false) {
					JOptionPane.showMessageDialog(null,
							"Opção escolhida:informação!");

					informacao = false;
				}
				if (ativarbotaotelainicial == false && ativarbotaologin == true) {

					caixa.telaInicial2(frame);

					caixa.limparcampos();
					ativarbotaotelainicial = true;
				}

			}
		});

	}

	public void delay(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new InterfaceCaixa();
	}

}
