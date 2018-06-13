package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.controlador.Resultado;

public interface IComando {
	
	Resultado execute(HttpServletRequest request, HttpServletResponse response);

}
