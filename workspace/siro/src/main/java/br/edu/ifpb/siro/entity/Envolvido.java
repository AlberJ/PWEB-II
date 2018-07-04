package br.edu.ifpb.siro.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ENVOLVIDO")
public class Envolvido {
	@Id
	@Column(name = "ID_ENVOLVIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NM_ENVOLVIDO")
	private String nome;

	@Column(name = "AP_ENVOLVIDO")
	private String apelido;
	
	@Column(name = "MAE")
	private String mae;
	
	@Column(name = "PAI")
	private String pai;
	
	@Column(name = "NASCIMENTO")
	private Date nascimento;
	
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@Column(name = "ENDERECO")
	private String endereco;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "PARTICIPACAO")
	private String participacao;
	
	public String getParticipacao() {
		return participacao;
	}

	public void setParticipacao(String participacao) {
		this.participacao = participacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getApelido() {
		return apelido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		return result;
	}
}
