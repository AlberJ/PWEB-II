package br.edu.ifpb.memoriam.entidade;

public enum Perfil {
	BASIC("Básico"),
	ADMIN("Administrador");
	
	private String nome;
	
	Perfil(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
