package Agencia;

import java.io.Serializable;

public class Cliente implements Serializable {

	private int login;
	private String nome;
	private int senha;
	private int saldo;

	public int getLogin() {
		return this.login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return this.senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

}
