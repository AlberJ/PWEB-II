package br.edu.ifpb.memoriam.facade;

import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import br.edu.ifpb.memoriam.dao.ContatoDAO;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.dao.UsuarioDAO;
import br.edu.ifpb.memoriam.entity.Contato;
import br.edu.ifpb.memoriam.entity.Usuario;

public class ContatoController {

	public void cadastrar(Contato contato, Usuario usuario) {
		ContatoDAO dao = new ContatoDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		UsuarioDAO udao = new UsuarioDAO();
		usuario = udao.findByLogin(usuario.getEmail());
		contato.setUsuario(usuario);
		if (contato.getId() == null) {
			dao.insert(contato);
		} else {
			dao.update(contato);
		}
		dao.commit();
	}

	public List<Contato> consultar(Usuario usuario) {
		ContatoDAO dao = new ContatoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Contato> contatos = dao.findAllFromUser(usuario);
		return contatos;
	}

	public Contato buscar(Map<String, String[]> parameterMap) throws Exception {
		String[] id = parameterMap.get("id");
		if (id == null)
			throw new Exception("Parametro ID não encontrado.");
		ContatoDAO dao = new ContatoDAO(PersistenceUtil.getCurrentEntityManager());
		Contato contato = dao.find(Integer.parseInt(id[0]));
		return contato;
	}

	public boolean excluir(Contato contato) {
		boolean excluiu = false;
		ContatoDAO dao = new ContatoDAO();
		try {
			dao.beginTransaction();
			Contato c = dao.find(contato.getId());
			dao.delete(c);
			dao.commit();
			excluiu = true;
		} catch (PersistenceException e) {
			dao.rollback();
		}
		return excluiu;

	}

}
