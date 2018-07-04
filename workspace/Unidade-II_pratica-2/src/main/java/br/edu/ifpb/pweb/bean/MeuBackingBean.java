package br.edu.ifpb.pweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bean")
@RequestScoped
public class MeuBackingBean {

	String nome;
	private int idade;
	private String faixa;
	private String mensagem = "Produzido  no  bbean";

	public String calculeFaixa() {

		if (idade > 18 && idade <= 25)
			faixa = "Jovem";

		if (idade >= 26 && idade <= 59)
			faixa = "Adulto";

		if (idade >= 59 && idade <= 90)
			faixa = "Idoso";

		return faixa;

	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getFaixa() {
		return faixa;
	}

	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public String maiusculas() {
		nome = nome.toUpperCase();
		return null;
	}

	public String minusculas() {
		nome = nome.toLowerCase();
		return null;
	}
}