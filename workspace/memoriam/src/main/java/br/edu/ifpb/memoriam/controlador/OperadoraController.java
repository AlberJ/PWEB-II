package br.edu.ifpb.memoriam.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifpb.memoriam.dao.OperadoraDAO;
import br.edu.ifpb.memoriam.entidade.Operadora;

public class OperadoraController {
	
	private EntityManager entityManager;
	
	private List<String> mensagensErro; 
	
	public OperadoraController(EntityManager em) {
		this.entityManager = em;
	}

	public List<Operadora> consulte() {
		OperadoraDAO dao = new OperadoraDAO(entityManager);
		List<Operadora> operadoras = dao.findAll();
		return operadoras;
	}

	public Resultado cadastre(Map<String, String[]> parametros) {
		Resultado resultado = new Resultado();
		Operadora operadora = null;
		if ((operadora = fromParametros(parametros)) != null) {
			OperadoraDAO dao = new OperadoraDAO(entityManager);
			dao.beginTransaction();
			if (operadora.getId() == null) {
				dao.insert(operadora);
			} else {
				dao.update(operadora);
			}
			dao.commit();
			resultado.setErro(false);
			resultado.addMensagem("Operadora criado com sucesso");
		} else {
			resultado.setEntidade(operadora);
			resultado.setErro(true);
			resultado.setMensagens(this.mensagensErro);
		}
		return resultado;
	}
	
	public Operadora busque(Map<String, String[]> parameterMap)  {
		String[] id = parameterMap.get("id");
		OperadoraDAO dao = new OperadoraDAO(entityManager);
		Operadora operadora = dao.find(Integer.parseInt(id[0]));
		return operadora;
	}

	private Operadora fromParametros(Map<String, String[]> parametros) {
		String[] id = parametros.get("id");
		String[] nome = parametros.get("nome");
		String[] prefixo = parametros.get("prefixo");
		
		Operadora operadora = new Operadora();
		this.mensagensErro = new ArrayList<String>();
		
		if (id != null && id.length > 0 && !id[0].isEmpty()) {
			operadora.setId(Integer.parseInt(id[0]));
		}
		
		if (nome == null || nome.length == 0 || nome[0].isEmpty()) {
			this.mensagensErro.add("Nome é campo obrigatório!");
		} else {
			operadora.setNome(nome[0]);
		}

		if (prefixo == null || prefixo.length == 0 || prefixo[0].isEmpty()) {
			this.mensagensErro.add("Prefixo é campo obrigatório!");
		} else {
			Integer prefixoInt = null;
			try {
				prefixoInt = Integer.valueOf(prefixo[0]);
			} catch (NumberFormatException e) {
				this.mensagensErro.add("Prefixo deve ser um número inteiro!");
			}
			operadora.setPrefixo(prefixoInt);
		}
		
		return this.mensagensErro.isEmpty() ? operadora : null ;
	}

	public Resultado exclua(Map<String, String[]> parameterMap) {
		String ids[] = parameterMap.get("delids");
		OperadoraDAO dao = new OperadoraDAO(entityManager);
		Resultado r = new Resultado();
		try {
			dao.beginTransaction();
			for (String id : ids) {
				Operadora c = dao.find(Integer.parseInt(id));
				dao.delete(c);
			}
			dao.commit();
			r.setErro(false);
		} catch (PersistenceException e) {
			dao.rollback();
			r.setErro(true);
			r.addMensagem("Erro ao excluir operadora: ");
		}
		return r;
	}

}
