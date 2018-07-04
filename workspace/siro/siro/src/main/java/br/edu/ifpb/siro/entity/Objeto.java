package br.edu.ifpb.siro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_OBJETO")
public class Objeto {
	
	@Id
	@Column(name = "ID_OBJETO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "OBJ_CATEGORIA")
	private String categoria;
	
	@Column(name = "OBJ_DESCRICAO")
	private String descricao;
	
	@Column(name = "OBJ_VALOR")
	private String valor;
	
	@Column(name = "OBJ_PROPRIEDADE")
	private Envolvido propriedade;
	
	@Column(name = "OBJ_POSSE")
	private Envolvido posse;

	public Envolvido getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(Envolvido propriedade) {
		this.propriedade = propriedade;
	}

	public Envolvido getPosse() {
		return posse;
	}

	public void setPosse(Envolvido posse) {
		this.posse = posse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
