package br.edu.ifpb.siro.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.siro.entity.Envolvido;
import br.edu.ifpb.siro.entity.Objeto;

@ManagedBean
@ViewScoped
public class OcorrenciaBean {
	
	private Envolvido envolvido;
	private Objeto objeto;
	private List<Objeto> objetos;
	private List<Envolvido> envolvidos;
	private String natureza;
	private String complemento;
	
	
	@PostConstruct
	public void init() {
		envolvido = new Envolvido();
		envolvidos = new ArrayList<Envolvido>();
		
		objeto = new Objeto();
		objetos = new ArrayList<Objeto>();
		
	}

	public void inserirEnvolvido() {
		envolvidos.add(envolvido);
		envolvido = new Envolvido();
	}
	
	public void inserirObjeto() {
		objetos.add(objeto);
		objeto = new Objeto();
	}
	
		
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public List<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}


	public List<Envolvido> getEnvolvidos() {
		return envolvidos;
	}

	public void setEnvolvidos(List<Envolvido> envolvidos) {
		this.envolvidos = envolvidos;
	}

	public Envolvido getEnvolvido() {
		return envolvido;
	}

	public void setEnvolvido(Envolvido envolvido) {
		this.envolvido = envolvido;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
