package br.edu.ifpb.memoriam.entity;

public enum Perfil {
	BASIC("básico"),
	ADMIN("Administrador");
	
	private String nome;
	
	Perfil(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	
}
